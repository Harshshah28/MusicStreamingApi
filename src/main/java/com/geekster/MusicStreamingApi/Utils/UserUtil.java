package com.geekster.MusicStreamingApi.Utils;

import com.geekster.MusicStreamingApi.model.MusicUser;
import com.geekster.MusicStreamingApi.model.UserStatus;
import com.geekster.MusicStreamingApi.repo.IMusicRepository;
import com.geekster.MusicStreamingApi.repo.IMusicUserRepository;
import com.geekster.MusicStreamingApi.repo.IUserStatusRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtil {

    @Autowired
    IMusicUserRepository iMusicUserRepository;

    @Autowired
    IUserStatusRepo iUserStatusRepo;

    @Autowired
    IMusicRepository iMusicRepository;

    public JSONObject validateAdmin(JSONObject jsonObject) {
        JSONObject errorList = new JSONObject();

        if (jsonObject.has("username")) {
            String username = jsonObject.getString("username");

            List<MusicUser> userList = iMusicUserRepository.findByUsername(username);
            if(userList.size() > 0) {
                errorList.put("username", "This username already exists");
                return errorList;
            }
        } else {
            errorList.put("username", "Missing parameter");
        }
        if (jsonObject.has("firstName")) {

        } else {
            errorList.put("firstName", "Missing parameter");
        }

        if (jsonObject.has("lastName")) {

        } else {
            errorList.put("lastName", "Missing parameter");
        }

        if (jsonObject.has("gender")) {

        } else {
            errorList.put("gender", "Missing parameter");
        }

        if (jsonObject.has("email")) {
            String email = jsonObject.getString("email");
            if(!Validation.isValidEmail(email)) {
                errorList.put("email", "Please enter a valid email");
            }
        }
        else {
            errorList.put("email", "Missing parameter");
        }

        if (jsonObject.has("phoneNumber")) {
            String phoneNumber = jsonObject.getString("phoneNumber");
            if(!Validation.isValidPhoneNumber(phoneNumber)) {
                errorList.put("phoneNumber", "Please enter a valid phone number");
            }
        } else {
            errorList.put("phoneNumber", "Missing parameter");
        }


        return errorList;
    }


    public MusicUser setAdmin(JSONObject jsonObject) {
        MusicUser musicUser=new MusicUser();
        musicUser.setUserName(jsonObject.getString("username"));
        musicUser.setFirstName(jsonObject.getString("firstName"));
        musicUser.setLastName(jsonObject.getString("lastName"));
        musicUser.setEmail(jsonObject.getString("email"));
        musicUser.setPhoneNumber(jsonObject.getString("phoneNumber"));
        musicUser.setGender(jsonObject.getString("gender"));


        UserStatus userStatu=iUserStatusRepo.findById(1).get();
        musicUser.setStatusId(userStatu);


        JSONArray jsonArray=new JSONArray(jsonObject.getJSONArray("playlist"));

        ArrayList<Integer> aLis=new ArrayList<>();
        for(int i=0;i<jsonArray.toList().size();i++) {
            int musicId=jsonArray.getInt(i);
            aLis.add(musicId);
        }
        musicUser.setPlaylist(aLis);

        if(jsonObject.has("age")) {
            musicUser.setAge(jsonObject.getInt("age"));
        }
        return musicUser;
    }

}

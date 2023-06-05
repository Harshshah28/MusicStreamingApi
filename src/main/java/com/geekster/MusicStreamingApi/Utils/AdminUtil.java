package com.geekster.MusicStreamingApi.Utils;

import com.geekster.MusicStreamingApi.model.MusicAdmin;
import com.geekster.MusicStreamingApi.repo.IMusicAdmin;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminUtil {

    @Autowired
    IMusicAdmin iMusicAdmin;

    public MusicAdmin setAdmin(JSONObject jsonObject) {
        MusicAdmin musicAdmin = new MusicAdmin();
        musicAdmin.setAdminName(jsonObject.getString("adminName"));
        musicAdmin.setFirstName(jsonObject.getString("firstName"));
        musicAdmin.setLastName(jsonObject.getString("lastName"));
        musicAdmin.setEmail(jsonObject.getString("email"));
        musicAdmin.setPhoneNumber(jsonObject.getString("phoneNumber"));
        musicAdmin.setGender(jsonObject.getString("gender"));

        if(jsonObject.has("age")) {
            musicAdmin.setAge(jsonObject.getInt("age"));
        }

        return musicAdmin;
    }


    public JSONObject validateAdmin(JSONObject jsonObject) {
        JSONObject errorList = new JSONObject();

        if (jsonObject.has("adminName")) {

        } else {
            errorList.put("adminName", "Missing parameter");
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
            } else {
                errorList.put("email", "Missing parameter");
            }
            if (jsonObject.has("phoneNumber")) {
                String phoneNumber = jsonObject.getString("phoneNumber");
                if(!Validation.isValidPhoneNumber(phoneNumber)) {
                    errorList.put("phoneNumber", "Please enter a valid phone number");
                }
            }else {
                errorList.put("phoneNumber", "Missing parameter");
            }


        }
        return errorList;
    }
}

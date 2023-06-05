package com.geekster.MusicStreamingApi.service;

import com.geekster.MusicStreamingApi.Utils.MusicUtil;
import com.geekster.MusicStreamingApi.model.Music;
import com.geekster.MusicStreamingApi.repo.IMusicRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    IMusicRepository iMusicRepository;
    @Autowired
    MusicUtil musicUtil;

    public int addMusic(JSONObject jsonObject) {
        Music music =musicUtil.setMusic(jsonObject);

        Music music2=iMusicRepository.save(music);
        return music2.getMusicId();
    }

    public JSONArray getMusic(Integer id) {
        JSONArray jsonArray=new JSONArray();
        if(id!=null && iMusicRepository.findById(id).isPresent()) {
            Music music=iMusicRepository.findById(id).get();
            JSONObject jsonObject=musicUtil.setMusic(music);
            jsonArray.put(jsonObject);
        }
        else {
            List<Music> list=iMusicRepository.findAll();
            for(Music m:list) {
                JSONObject jsonObject=musicUtil.setMusic(m);
                jsonArray.put(jsonObject);
            }
        }
        return jsonArray;
    }

    public String updateMusic(int id, JSONObject music) {
        String str="";
        Music music1 =musicUtil.setMusic(music);
        try {
            //if(iMusicRepository.findById(id).isPresent()) {
            Music musicobj=iMusicRepository.findById(id).get();
            musicobj.setArtists(music1.getArtists());
            musicobj.setDuration(music1.getDuration());
            musicobj.setGenre(music1.getGenre());
            musicobj.setName(music1.getName());
            iMusicRepository.save(musicobj);
            //}
            str="Update Done";

        }
        catch (Exception e) {
            str="User Not Found";
        }
        return str;

    }

    public String deleteMusic(int id) {
        String msgString="";
        try {
            if(iMusicRepository.findById(id).isPresent()) {
                iMusicRepository.deleteById(id);
                msgString="deleted";
            }
            else {
                msgString="user not found";
            }
        }
        catch (Exception e) {
            msgString=e.getMessage();
        }
        return msgString;
    }

}

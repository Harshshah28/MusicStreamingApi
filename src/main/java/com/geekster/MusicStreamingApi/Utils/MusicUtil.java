package com.geekster.MusicStreamingApi.Utils;

import com.geekster.MusicStreamingApi.model.Music;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class MusicUtil {



    public JSONObject validateMusic(JSONObject jsonObject) {
        JSONObject errorList = new JSONObject();

        if (jsonObject.has("name")) {

        } else {
            errorList.put("MusicName", "Missing parameter");
        }
        if (jsonObject.has("artists")) {

        } else {
            errorList.put("artist", "Missing parameter");
        }

        if (jsonObject.has("duration")) {

        } else {
            errorList.put("duration", "Missing parameter");
        }

        if (jsonObject.has("genre")) {

        } else {
            errorList.put("genre", "Missing parameter");
        }

        return errorList;
    }

    public Music setMusic(JSONObject jsonObject) {
        Music music=new Music();
        music.setName(jsonObject.getString("name"));
        music.setArtists(jsonObject.getString("artists"));
        music.setDuration(jsonObject.getDouble("duration"));
        music.setGenre(jsonObject.getString("genre"));

        return music;
    }

    public JSONObject setMusic(Music music) {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("musicId", music.getMusicId());
        jsonObject.put("name", music.getName());
        jsonObject.put("duration", music.getDuration());
        jsonObject.put("genre", music.getGenre());
        jsonObject.put("artists", music.getArtists());


        return jsonObject;
    }
}

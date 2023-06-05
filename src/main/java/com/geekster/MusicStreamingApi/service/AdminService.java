package com.geekster.MusicStreamingApi.service;

import com.geekster.MusicStreamingApi.Utils.AdminUtil;
import com.geekster.MusicStreamingApi.model.MusicAdmin;
import com.geekster.MusicStreamingApi.repo.IMusicAdmin;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminUtil adminUtil;

    @Autowired
    IMusicAdmin iMusicAdmin;

    public int addAdmin(JSONObject admin) {
        MusicAdmin musicAdmin=adminUtil.setAdmin(admin);
        MusicAdmin musicAdmin2=iMusicAdmin.save(musicAdmin);
        return musicAdmin2.getAdminId();
    }

}

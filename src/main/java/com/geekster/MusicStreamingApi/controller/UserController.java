package com.geekster.MusicStreamingApi.controller;

import com.geekster.MusicStreamingApi.Utils.UserUtil;
import com.geekster.MusicStreamingApi.model.Music;
import com.geekster.MusicStreamingApi.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userController")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserUtil userUtil;


    @PostMapping(value = "/addUser")
    public ResponseEntity<String> addUser(@RequestBody String user){
        JSONObject jsonObject=new JSONObject(user);
        JSONObject isValidJsonObject=userUtil.validateAdmin(jsonObject);

        if(isValidJsonObject.isEmpty()) {
            int id=userService.addUser(jsonObject);
            return new ResponseEntity<String>("User added " +id, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(isValidJsonObject.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="getPlaylist/{id}")
    public List<Music> getPlayList(@PathVariable Integer id){
        return userService.getPlaylist(id);

    }

    @DeleteMapping(value = "deleteMusic/{id}/{musicId}")
    public String deleteMusic(@PathVariable Integer id,@PathVariable Integer musicId) {
        return userService.deleteMusic(id,musicId);


    }
}

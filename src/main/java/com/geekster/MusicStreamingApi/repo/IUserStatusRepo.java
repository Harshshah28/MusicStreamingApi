package com.geekster.MusicStreamingApi.repo;

import com.geekster.MusicStreamingApi.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStatusRepo extends JpaRepository<UserStatus, Integer> {

}
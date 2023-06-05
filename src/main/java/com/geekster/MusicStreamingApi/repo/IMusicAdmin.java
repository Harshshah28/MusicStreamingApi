package com.geekster.MusicStreamingApi.repo;

import com.geekster.MusicStreamingApi.model.MusicAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicAdmin extends JpaRepository<MusicAdmin, Integer> {

}

package com.geekster.MusicStreamingApi.repo;

import com.geekster.MusicStreamingApi.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

}

package com.geekster.MusicStreamingApi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_music_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="usrname")
    private String userName;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="gender")
    private String gender;

    @Column(name="age")
    private Integer age;
    @Column(name="email")
    private String email;
    @Column(name="phoneNumber")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="status_id")
    private UserStatus statusId;

    @Column(name="playlist")
    private List<Integer> playlist;


}
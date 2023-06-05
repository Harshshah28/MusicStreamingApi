package com.geekster.MusicStreamingApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_status")
public class UserStatus {

    @Id
    @Column(name="status_id")
    private int StatusId;
    @Column(name="status_name")
    private String statusName;


}

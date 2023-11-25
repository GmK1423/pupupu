package com.example.pupupu.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tgId;
    private Long vkId;

    private Integer botState;
    private String nickname;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private UserStatus statusId;



}

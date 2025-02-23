package com.Quiz.Authentication.UserDetails;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;


@Entity
@Data
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String UserName;
    private String email;
    private String password;
}

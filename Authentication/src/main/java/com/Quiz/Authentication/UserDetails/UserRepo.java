package com.Quiz.Authentication.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByEmail(String username);
}

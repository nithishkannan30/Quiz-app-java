package com.Quiz.Authentication.Security;

import com.Quiz.Authentication.UserDetails.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "upto this the user can access";
    }

    @PostMapping("/user/adduser")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addNewUser(userInfo);
    }

    @PostMapping("/user/authentication")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        System.out.println("getting ");// Fix: Add @RequestBody
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return "Successfully Logged in";
            }
        } catch (Exception e) {
            return "Invalid Username or Password";
        }
        return "Authentication Failed";
    }
}

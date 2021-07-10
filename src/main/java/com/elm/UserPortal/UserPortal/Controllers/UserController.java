package com.elm.UserPortal.UserPortal.Controllers;

import com.elm.UserPortal.UserPortal.Models.User;
import com.elm.UserPortal.UserPortal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index(Authentication authentication) {
        try {
            return "<h1> " + authentication.getName();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }
}

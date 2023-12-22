package br.com.pedro.Ecommerceapi.controllers;

import br.com.pedro.Ecommerceapi.dtos.UserDTO;
import br.com.pedro.Ecommerceapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody UserDTO user){
        return userService.create(user);
    }

}

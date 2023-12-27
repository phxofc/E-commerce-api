package br.com.pedro.Ecommerceapi.controllers;

import br.com.pedro.Ecommerceapi.dtos.UserDTO;
import br.com.pedro.Ecommerceapi.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user){

        UserDTO persisted = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(persisted);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<UserDTO> users = userService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id){

        UserDTO persisted = userService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(persisted);
    }


    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user){

        UserDTO persisted = userService.update(user);

        return ResponseEntity.status(HttpStatus.OK).body(persisted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){

        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
    }

}

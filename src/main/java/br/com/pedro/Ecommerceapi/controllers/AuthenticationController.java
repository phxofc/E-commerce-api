package br.com.pedro.Ecommerceapi.controllers;

import br.com.pedro.Ecommerceapi.dtos.AuthenticationDTO;
import br.com.pedro.Ecommerceapi.dtos.LoginResponseDTO;
import br.com.pedro.Ecommerceapi.dtos.RegisterDTO;
import br.com.pedro.Ecommerceapi.exceptions.IncorrectLoginException;
import br.com.pedro.Ecommerceapi.models.UserModel;
import br.com.pedro.Ecommerceapi.repositories.UserRepository;
import br.com.pedro.Ecommerceapi.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {


        try {

            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            if(auth == null){

                throw new IncorrectLoginException();

            }

            var token = tokenService.generateToken((UserModel)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));

        }catch (AuthenticationException e){
            throw new IncorrectLoginException("failed to authenticate ", e);
        }





    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
    if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    UserModel newUser = new UserModel(data.username(), encryptedPassword, data.role());
    this.repository.save(newUser);
    return ResponseEntity.ok().build();
    }

}

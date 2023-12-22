package br.com.pedro.Ecommerceapi.services;

import br.com.pedro.Ecommerceapi.dtos.UserDTO;
import br.com.pedro.Ecommerceapi.models.UserModel;
import br.com.pedro.Ecommerceapi.repositories.UserRepository;
import br.com.pedro.Ecommerceapi.utils.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO create(UserDTO user){

        var entity = Mapper.parseObject(user, UserModel.class);
        var vo = Mapper.parseObject(userRepository.save(entity),UserDTO.class);
        return vo;
    }

}

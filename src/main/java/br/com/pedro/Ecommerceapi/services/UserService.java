package br.com.pedro.Ecommerceapi.services;

import br.com.pedro.Ecommerceapi.dtos.UserDTO;
import br.com.pedro.Ecommerceapi.models.UserModel;
import br.com.pedro.Ecommerceapi.repositories.UserRepository;
import br.com.pedro.Ecommerceapi.utils.mapper.Mapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO create(UserDTO user){

        var entity = Mapper.parseObject(user, UserModel.class);
        var vo = Mapper.parseObject(userRepository.save(entity),UserDTO.class);
        return vo;
    }

    public List<UserDTO> findAll(){

        var vo = Mapper.parseListObject(userRepository.findAll(),UserDTO.class);

        return vo;
    }

    public UserDTO findById(Long id){
        var vo = Mapper.parseObject(userRepository.findById(id),UserDTO.class);

        return vo;
    }


    public UserDTO update(UserDTO user){

        var entity = userRepository.findById(user.getId()).orElseThrow();
        entity.setName(user.getName());
        entity.setUsername(user.getUsername());
        entity.setRole(user.getRole());

        var vo = Mapper.parseObject(userRepository.save(entity),UserDTO.class);
        return vo;
    }

    public void delete(Long id){
        var entity = userRepository.findById(id).orElseThrow();
        userRepository.delete(entity);
    }
}

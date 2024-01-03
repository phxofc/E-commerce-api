package br.com.pedro.Ecommerceapi.repositories;

import br.com.pedro.Ecommerceapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<UserModel,Long> {

    UserDetails findByUsername(String username);
}

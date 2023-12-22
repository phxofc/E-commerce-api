package br.com.pedro.Ecommerceapi.repositories;

import br.com.pedro.Ecommerceapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel,Long> {}

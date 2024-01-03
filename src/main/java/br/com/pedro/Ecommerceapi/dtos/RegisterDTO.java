package br.com.pedro.Ecommerceapi.dtos;

import br.com.pedro.Ecommerceapi.enums.UserRole;

public record RegisterDTO (String username, String password, UserRole role){
}

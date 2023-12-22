package br.com.pedro.Ecommerceapi.dtos;

import br.com.pedro.Ecommerceapi.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Long id;

    private String name;


    private String username;

    private UserRole role;

}
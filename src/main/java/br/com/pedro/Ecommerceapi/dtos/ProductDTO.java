package br.com.pedro.Ecommerceapi.dtos;


import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private Integer code;

    private double price;
}

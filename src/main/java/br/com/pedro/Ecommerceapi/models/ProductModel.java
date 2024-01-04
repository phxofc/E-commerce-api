package br.com.pedro.Ecommerceapi.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    private Long id;
    @NonNull
    @Valid
    private String name;
    @Column(unique = true)
    @Valid
    private Integer code;
    @NonNull
    @Valid
    private double price;



}

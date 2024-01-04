package br.com.pedro.Ecommerceapi.controllers;

import br.com.pedro.Ecommerceapi.dtos.ProductDTO;
import br.com.pedro.Ecommerceapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto){

        ProductDTO persisted = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(persisted);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){

        List<ProductDTO> products = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id){

        ProductDTO persisted = service.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(persisted);
    }


    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO dto){

        ProductDTO persisted = service.update(dto);

        return ResponseEntity.status(HttpStatus.OK).body(persisted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){

        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
    }
}

package br.com.pedro.Ecommerceapi.repositories;

import br.com.pedro.Ecommerceapi.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {}

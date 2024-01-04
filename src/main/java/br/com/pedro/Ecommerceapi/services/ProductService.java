package br.com.pedro.Ecommerceapi.services;

import br.com.pedro.Ecommerceapi.dtos.ProductDTO;
import br.com.pedro.Ecommerceapi.exceptions.ApplicationExceptionHandler;
import br.com.pedro.Ecommerceapi.exceptions.NotFoundException;
import br.com.pedro.Ecommerceapi.models.ProductModel;
import br.com.pedro.Ecommerceapi.repositories.ProductRepository;
import br.com.pedro.Ecommerceapi.utils.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ProductDTO create(ProductDTO dto){

        var entity = Mapper.parseObject(dto, ProductModel.class);

        var vo = Mapper.parseObject(repository.save(entity),ProductDTO.class);

        return vo;

    }

    public List<ProductDTO> findAll(){

        var vo = Mapper.parseListObject(repository.findAll(),ProductDTO.class);

        return vo;
    }

    public ProductDTO update(ProductDTO dto){

        var entity = repository.findById(dto.getId()).orElseThrow();
        entity.setName(dto.getName());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        var vo = Mapper.parseObject(repository.save(entity), ProductDTO.class);

        return vo;

    }

    public ProductDTO findById(Long id){



        var vo = Mapper.parseObject(repository.findById(id), ProductDTO.class);

        if(vo == null){
            throw new NotFoundException();
        }

        return vo;

    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);

        repository.delete(entity);

    }

}

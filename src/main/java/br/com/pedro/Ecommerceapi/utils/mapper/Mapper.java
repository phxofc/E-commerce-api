package br.com.pedro.Ecommerceapi.utils.mapper;

import br.com.pedro.Ecommerceapi.models.UserModel;

import java.util.*;

public class Mapper {

    private static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    //static {
     //   mapper.createTypeMap(
           ////     UserModel.class,
            //    UserDTO.class).addMapping(
          //      UserModel::getId,UserDTO::setId);

  //  }

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return  mapper.map(origin,destination);

    }
    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o: origin) {
            destinationObjects.add(mapper.map(o,destination));
        }
        return  destinationObjects;

    }

}

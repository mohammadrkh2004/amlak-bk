package ir.amlak.amlaktamrin.mapper;

import com.sun.jndi.cosnaming.IiopUrl;
import ir.amlak.amlaktamrin.dto.AddressDTO;
import ir.amlak.amlaktamrin.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressEntity convertToEntity(AddressDTO addressDTO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAlley(addressDTO.getAlley());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setProvince(addressDTO.getProvince());
        addressEntity.setPostalCode(addressDTO.getPostalCode());
        addressEntity.setStreet(addressDTO.getStreet());
        return addressEntity;
    }

    public AddressDTO convertToDTO(AddressEntity addressEntity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAlley(addressEntity.getAlley());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setProvince(addressEntity.getProvince());
        addressDTO.setPostalCode(addressEntity.getPostalCode());
        addressDTO.setStreet(addressEntity.getStreet());
        return addressDTO;
    }
}

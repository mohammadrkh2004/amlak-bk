package ir.amlak.amlaktamrin.mapper;


import ir.amlak.amlaktamrin.dto.OwnerDTO;
import ir.amlak.amlaktamrin.entity.EstateEntity;
import ir.amlak.amlaktamrin.entity.OwnerEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Component
public class OwnerMapper {
    @Autowired
    private EstateMapper eststeMapper;

    public OwnerEntity convertToEntity(OwnerDTO ownerDTO) {
        OwnerEntity ownerEntity = new OwnerEntity();
        List<EstateEntity> estateEntity = new ArrayList<>();
        ownerEntity.setFirstName(ownerDTO.getFirstName());
        ownerEntity.setLastName(ownerDTO.getLastName());
        ownerEntity.setPhoneNumber(ownerDTO.getPhoneNumber());
        ownerEntity.setNationalCode(ownerDTO.getNationalCode());
        ownerEntity.setOwnerType(ownerDTO.getOwnerType());
        ownerEntity.setCreatedTime(new Date());
        ownerEntity.setEstates(estateEntity);
        return ownerEntity;
    }

    public OwnerDTO convertToDTO(OwnerEntity ownerEntity) {
        OwnerDTO ownerDTO = new OwnerDTO();
        List<EstateEntity> estateEntity = ownerEntity.getEstates();
        ownerDTO.setFirstName(ownerEntity.getFirstName());
        ownerDTO.setLastName(ownerEntity.getLastName());
        ownerDTO.setPhoneNumber(ownerEntity.getPhoneNumber());
        ownerDTO.setNationalCode(ownerEntity.getNationalCode());
        ownerDTO.setOwnerType(ownerEntity.getOwnerType());
        ownerDTO.setEstateDTO(eststeMapper.convertToDTOList(estateEntity));
        return ownerDTO;
    }

    public List<OwnerDTO> convertToDTOList(List<OwnerEntity> ownerEntities) {
        List<OwnerDTO> ownerDTOList = new ArrayList<>();
        for (OwnerEntity ownerEntity : ownerEntities) {
            ownerDTOList.add(convertToDTO(ownerEntity));
        }
        return ownerDTOList;
    }

}

package ir.amlak.amlaktamrin.mapper;

import ir.amlak.amlaktamrin.dto.EstateDTO;
import ir.amlak.amlaktamrin.entity.AddressEntity;
import ir.amlak.amlaktamrin.entity.EstateEntity;
import ir.amlak.amlaktamrin.entity.OwnerEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Component
public class EstateMapper {

    AddressMapper addressMapper = new AddressMapper();


    public EstateEntity convertToEntity(EstateDTO estateDTO, OwnerEntity ownerEntity, AddressEntity addressEntity) {
        EstateEntity estateEntity = new EstateEntity();
        estateEntity.setEstateName(estateDTO.getEstateName());
        estateEntity.setTrackingCode(estateDTO.getTrackingCode());
        estateEntity.setCreatedTime(new Date());
        estateEntity.setSquareMeters(estateDTO.getSquareMeters());
        estateEntity.setOwnerIdentity(ownerEntity.getNationalCode());
        estateEntity.setAddress(addressEntity);
        estateEntity.setOwner(ownerEntity);

        return estateEntity;
    }

    public EstateDTO convertToDTO(EstateEntity estateEntity) {
        EstateDTO estateDTO = new EstateDTO();
        estateDTO.setEstateName(estateEntity.getEstateName());
        estateDTO.setTrackingCode(estateEntity.getTrackingCode());
        estateDTO.setSquareMeters(estateEntity.getSquareMeters());
        estateDTO.setOwnerIdentity(estateEntity.getOwnerIdentity());
        estateDTO.setAddress(addressMapper.convertToDTO(estateEntity.getAddress()));
        return estateDTO;
    }

    public List<EstateDTO> convertToDTOList(List<EstateEntity> estateEntites) {
        List<EstateDTO> estateDTOList = new ArrayList<>();
        for (EstateEntity estateEntity : estateEntites) {
            estateDTOList.add(convertToDTO(estateEntity));
        }
        return estateDTOList;
    }

}

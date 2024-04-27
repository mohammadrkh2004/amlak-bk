package ir.amlak.amlaktamrin.service.Impl;

import ir.amlak.amlaktamrin.dto.OwnerDTO;
import ir.amlak.amlaktamrin.entity.OwnerEntity;
import ir.amlak.amlaktamrin.exception.impl.OwnerAlreadyExists;
import ir.amlak.amlaktamrin.exception.impl.OwnerDoesnotExists;
import ir.amlak.amlaktamrin.mapper.OwnerMapper;
import ir.amlak.amlaktamrin.repository.OwnerDAO;
import ir.amlak.amlaktamrin.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerDAO ownerDAO;
    @Autowired
    private OwnerMapper ownerMapper;

    @Transactional
    @Override
    public OwnerDTO save(OwnerDTO ownerDTO) throws Exception {

        if (ownerDAO.existsByNationalCode(ownerDTO.getNationalCode())) {
            throw new OwnerAlreadyExists();

        } else {

            OwnerEntity ownerEntity = ownerMapper.convertToEntity(ownerDTO);
            ownerDAO.save(ownerEntity);
            return ownerDTO;
        }

    }

    @Override
    public OwnerDTO getUser(String nationalCode) {
        if (!ownerDAO.existsByNationalCode(nationalCode)) {
            throw new OwnerDoesnotExists();
        } else {
            OwnerEntity ownerEntity = ownerDAO.findByNationalCode(nationalCode);
            OwnerDTO ownerDTO = ownerMapper.convertToDTO(ownerEntity);
            return ownerDTO;
        }
    }

    @Transactional
    @Override
    public Boolean deleteUser(String nationalCode) throws Exception {
        OwnerEntity ownerEntity = ownerDAO.findByNationalCode(nationalCode);
        ownerDAO.delete(ownerEntity);
        return true;

    }

    @Override
    public OwnerDTO updateUser(String nationalCode, OwnerDTO ownerDTO) {
        if (!ownerDAO.existsByNationalCode(nationalCode)) {
            throw new OwnerDoesnotExists();
        } else {

            OwnerEntity ownerEntity = ownerDAO.findByNationalCode(nationalCode);
//        OwnerDTO dto = ownerMapper.convertToDTO(ownerEntity);
//        ownerDAO.save(ownerMapper.convertToEntity(dto));


            ownerEntity.setOwnerType(ownerDTO.getOwnerType());
            ownerEntity.setNationalCode(ownerDTO.getNationalCode());
            ownerEntity.setPhoneNumber(ownerDTO.getPhoneNumber());
            ownerEntity.setFirstName(ownerDTO.getFirstName());
            ownerEntity.setLastName(ownerDTO.getLastName());
            ownerEntity.setUpdatedTime(new Date());
            ownerDAO.save(ownerEntity);
            return ownerDTO;
        }
    }

    @Override
    public List<OwnerDTO> getAll() {
        List<OwnerEntity> ownerEntity = ownerDAO.findAll();
        List<OwnerDTO> ownerDTO = ownerMapper.convertToDTOList(ownerEntity);
        return ownerDTO;
    }


}
package ir.amlak.amlaktamrin.service.Impl;

import ir.amlak.amlaktamrin.dto.EstateDTO;
import ir.amlak.amlaktamrin.entity.AddressEntity;
import ir.amlak.amlaktamrin.entity.EstateEntity;
import ir.amlak.amlaktamrin.entity.OwnerEntity;
import ir.amlak.amlaktamrin.exception.GlobalExceptionHandler;
import ir.amlak.amlaktamrin.exception.impl.EstateAlreadyExists;
import ir.amlak.amlaktamrin.exception.impl.EstateDoesnotExists;
import ir.amlak.amlaktamrin.exception.impl.OwnerDoesnotExists;
import ir.amlak.amlaktamrin.mapper.AddressMapper;
import ir.amlak.amlaktamrin.mapper.EstateMapper;
import ir.amlak.amlaktamrin.mapper.OwnerMapper;
import ir.amlak.amlaktamrin.repository.AddressDAO;
import ir.amlak.amlaktamrin.repository.EstateDAO;
import ir.amlak.amlaktamrin.repository.OwnerDAO;
import ir.amlak.amlaktamrin.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {
    @Autowired
    private EstateDAO estateDAO;
    @Autowired
    private EstateMapper estateMapper;
    @Autowired
    private OwnerMapper ownerMapper;
    @Autowired
    private OwnerDAO ownerDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;


    @Override
    public EstateDTO create(EstateDTO estateDTO, String nationalCode) {

        if (estateDAO.existsByTrackingCode(estateDTO.getTrackingCode())) {
            throw new EstateAlreadyExists();
        }
        else if (!ownerDAO.existsByNationalCode(nationalCode)) {
            throw new OwnerDoesnotExists();

        }
        else {
            OwnerEntity ownerEntity = ownerDAO.findByNationalCode(nationalCode);
            AddressEntity addressEntity = addressMapper.convertToEntity(estateDTO.getAddress());
            EstateEntity estateEntity = estateMapper.convertToEntity(estateDTO, ownerEntity, addressEntity);
            ownerDAO.save(ownerEntity);
            addressDAO.save(addressEntity);
            estateDAO.save(estateEntity);
            return estateDTO;
        }


    }

    @Override
    public EstateDTO getEstate(String trackingCode) {


        if (estateDAO.existsByTrackingCode(trackingCode)) {
            throw new EstateAlreadyExists();

        } else {
            EstateEntity estateEntity = estateDAO.findByTrackingCode(trackingCode);
            EstateDTO estateDTO = estateMapper.convertToDTO(estateEntity);
            return estateDTO;
        }

    }

    @Override
    public Boolean deleteEstate(String trackingCode) {

        if (!estateDAO.existsByTrackingCode((trackingCode))) {
            throw new EstateDoesnotExists();
        } else {
            EstateEntity estateEntity = estateDAO.findByTrackingCode(trackingCode);
            AddressEntity addressEntity = estateEntity.getAddress();
            estateDAO.delete(estateEntity);
            addressDAO.delete(addressEntity);

            return true;

        }


    }

    @Override
    public EstateDTO updateEstate(String trackingCode, EstateDTO estateDTO) {
        if (!estateDAO.existsByTrackingCode(trackingCode))
        {
            throw new EstateDoesnotExists();
        }
        else {
            EstateEntity estateEntity = estateDAO.findByTrackingCode(trackingCode);
            AddressEntity addressEntity = estateEntity.getAddress();
            estateEntity.setEstateName(estateDTO.getEstateName());
            estateEntity.setAddress(addressEntity);
            estateEntity.setSquareMeters(estateDTO.getSquareMeters());
            estateEntity.setOwnerIdentity(estateDTO.getOwnerIdentity());
            estateEntity.setUpdatedTime(new Date());
            estateDAO.save(estateEntity);
            return estateDTO;
        }
    }

    @Override
    public List<EstateDTO> getAllEstates() {
        List<EstateEntity> estateEntity = estateDAO.findAll();
        List<EstateDTO> estateDTO = estateMapper.convertToDTOList(estateEntity);
        return estateDTO;

    }


}
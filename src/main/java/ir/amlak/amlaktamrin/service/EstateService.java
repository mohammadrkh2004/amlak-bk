package ir.amlak.amlaktamrin.service;

import ir.amlak.amlaktamrin.dto.EstateDTO;
import ir.amlak.amlaktamrin.entity.EstateEntity;

import java.util.List;

public interface EstateService {
    EstateDTO create(EstateDTO estateDTO, String nationalCode);
    EstateDTO getEstate(String trackingCode);
    Boolean deleteEstate(String trackingCode);

    EstateDTO updateEstate(String trackingCode ,EstateDTO estateDTO);
    List<EstateDTO> getAllEstates();
}
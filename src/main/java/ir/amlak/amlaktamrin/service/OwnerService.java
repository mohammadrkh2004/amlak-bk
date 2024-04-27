package ir.amlak.amlaktamrin.service;

import ir.amlak.amlaktamrin.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    OwnerDTO save(OwnerDTO ownerDTO) throws Exception;
    OwnerDTO getUser(String nationalCode);
    Boolean deleteUser(String nationalCode) throws Exception;
    OwnerDTO updateUser(String nationalCode, OwnerDTO ownerDTO);
    List<OwnerDTO> getAll();
}



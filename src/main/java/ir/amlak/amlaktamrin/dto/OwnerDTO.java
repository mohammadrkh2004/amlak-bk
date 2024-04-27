package ir.amlak.amlaktamrin.dto;


import lombok.Data;

import java.util.List;

@Data
public class OwnerDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String nationalCode;
    private String ownerType;
    private List<EstateDTO> estateDTO;
}

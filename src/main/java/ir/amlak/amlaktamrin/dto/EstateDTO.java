package ir.amlak.amlaktamrin.dto;


import lombok.Data;

@Data
public class EstateDTO {

    private String estateName;
    private String trackingCode;
    private int squareMeters;
    private String ownerIdentity;
    private AddressDTO address;



}

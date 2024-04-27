package ir.amlak.amlaktamrin.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String province;
    private String city;
    private String street;
    private String alley;
    private String postalCode;
}

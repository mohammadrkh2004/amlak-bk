package ir.amlak.amlaktamrin.entity;

import javax.persistence.*;

@Entity
@Table(name = "address_tbl")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String province;
    private String city;
    private String street;
    private String alley;
    private String postalCode;


    public AddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressEntity(String province, String city, String street, String alley, String postalCode) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;


    }
}

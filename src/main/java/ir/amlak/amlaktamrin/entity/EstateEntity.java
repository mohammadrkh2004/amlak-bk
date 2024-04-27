package ir.amlak.amlaktamrin.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.amlak.amlaktamrin.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estate_tbl")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EstateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estateName;
    private String trackingCode;
    private int squareMeters;
    private String ownerIdentity;

    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date updatedTime;

    @OneToOne(cascade = CascadeType.REMOVE)
    private AddressEntity address;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OwnerEntity owner;


    public EstateEntity(Long id, String estateName, String trackingCode, int squareMeters, String ownerIdentity, Date createdTime, Date updatedTime, AddressEntity address, OwnerEntity owner) {
        this.id = id;
        this.estateName = estateName;
        this.trackingCode = trackingCode;
        this.squareMeters = squareMeters;
        this.ownerIdentity = ownerIdentity;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.address = address;
        this.owner = owner;
    }


    public EstateEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getOwnerIdentity() {
        return ownerIdentity;
    }

    public void setOwnerIdentity(String ownerIdentity) {
        this.ownerIdentity = ownerIdentity;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }


}

package ir.amlak.amlaktamrin.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*import com.sun.org.apache.xpath.internal.operations.String;*/
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "owner_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Column(unique = true)
    private String nationalCode;
    private String ownerType;

    @CreatedDate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date createdTime;
    @LastModifiedDate
    private Date updatedTime;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<EstateEntity> estates;






    public OwnerEntity() {
    }

    public OwnerEntity(String firstName, String lastName, String phoneNumber, String nationalCode,String ownerType, List<EstateEntity> estates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.estates = estates;
        this.ownerType= ownerType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public List<EstateEntity> getEstates() {
        return estates;
    }

    public void setEstates(List<EstateEntity> estates) {
        this.estates = estates;
    }


}

package ir.amlak.amlaktamrin.repository;

import ir.amlak.amlaktamrin.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDAO extends JpaRepository<OwnerEntity, Long> {
    OwnerEntity findByNationalCode(String nationalCode);

    Boolean existsByNationalCode(String nationalCode);



}

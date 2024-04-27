package ir.amlak.amlaktamrin.repository;

import ir.amlak.amlaktamrin.entity.EstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateDAO extends JpaRepository<EstateEntity,Long> {
    EstateEntity findByTrackingCode(String trackingCode);
    Boolean existsByTrackingCode(String trackingCode);

}

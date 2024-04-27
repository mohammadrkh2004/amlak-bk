package ir.amlak.amlaktamrin.repository;

import ir.amlak.amlaktamrin.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<AddressEntity, Long>{
}

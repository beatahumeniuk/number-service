package pl.beatahumeniuk.decertonumberservicecore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.decertonumberservicecore.entity.RandomNumberDbEntity;

@Repository
public interface RandomNumberDBRepository extends JpaRepository<RandomNumberDbEntity, Long> {

}

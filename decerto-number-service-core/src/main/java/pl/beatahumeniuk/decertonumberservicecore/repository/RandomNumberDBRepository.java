package pl.beatahumeniuk.decertonumberservicecore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberDB;

@Repository
public interface RandomNumberDBRepository extends JpaRepository<RandomNumberDB, Long> {

}

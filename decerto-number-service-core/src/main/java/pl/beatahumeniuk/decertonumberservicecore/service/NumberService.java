package pl.beatahumeniuk.decertonumberservicecore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.beatahumeniuk.decertonumberservicecore.config.NumbersProperties;
import pl.beatahumeniuk.decertonumberservicecore.entity.RandomNumberDbEntity;
import pl.beatahumeniuk.decertonumberservicecore.repository.RandomNumberDBRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final RandomNumberDBRepository randomNumberDBRepository;
    private final NumbersProperties numbersProperties;

    public BigDecimal getFromDB() {
        Optional<RandomNumberDbEntity> randomNumberDBOptional = randomNumberDBRepository.findById(getRandomIndex());
        return randomNumberDBOptional.map(RandomNumberDbEntity::getValue).orElse(null);
    }

    private Long getRandomIndex() {
       return (long) new Random().nextInt(numbersProperties.getDbItemsNumber());
    }

}

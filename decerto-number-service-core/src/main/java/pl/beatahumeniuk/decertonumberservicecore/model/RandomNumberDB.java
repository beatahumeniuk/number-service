package pl.beatahumeniuk.decertonumberservicecore.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.beatahumeniuk.decertonumberservicecore.config.NumbersProperties;
import pl.beatahumeniuk.decertonumberservicecore.entity.RandomNumberDbEntity;
import pl.beatahumeniuk.decertonumberservicecore.repository.RandomNumberDBRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class RandomNumberDB extends RandomNumber {

    private final RandomNumberDBRepository randomNumberDBRepository;
    private final NumbersProperties numbersProperties;

    public BigDecimal getRandomValue() {
        return getFromDB();
    }

    private BigDecimal getFromDB() {
        Optional<RandomNumberDbEntity> randomNumberDBOptional = randomNumberDBRepository.findById(getRandomIndex());
        return randomNumberDBOptional.map(RandomNumberDbEntity::getValue).orElse(null);
    }

    private Long getRandomIndex() {
        return (long) new Random().nextInt(numbersProperties.getDbItemsNumber());
    }

}

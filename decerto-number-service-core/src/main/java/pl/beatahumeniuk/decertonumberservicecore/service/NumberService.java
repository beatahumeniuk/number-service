package pl.beatahumeniuk.decertonumberservicecore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.beatahumeniuk.decertonumberservicecore.config.NumbersProperties;
import pl.beatahumeniuk.decertonumberservicecore.entity.RandomNumberDbEntity;
import pl.beatahumeniuk.decertonumberservicecore.model.OperationType;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumber;
import pl.beatahumeniuk.decertonumberservicecore.repository.RandomNumberDBRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NumberService {

    public BigDecimal calculate(RandomNumber num1, RandomNumber num2, OperationType operationType) {

        BigDecimal value1 = num1.getRandomValue();
        BigDecimal value2 = num2.getRandomValue();

        switch (operationType) {
            case ADDITION:
                return num1.getRandomValue().add(value2);
            case SUBTRACT:
                return num1.getRandomValue().subtract(value2);
            case DIVIDE:
                return value1 != null ? value1.divide(value2, 2) : null;
            case MULTIPLICATION:
                return value1.multiply(value2);
            default:
                return null;
        }
    }
}

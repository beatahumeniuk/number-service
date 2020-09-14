package pl.beatahumeniuk.decertonumberservicecore.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@Component
public class RandomNumberJava extends RandomNumber {

    public BigDecimal getRandomValue() {
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2);
    }
}

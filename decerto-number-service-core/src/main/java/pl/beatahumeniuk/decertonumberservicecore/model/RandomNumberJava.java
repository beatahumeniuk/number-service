package pl.beatahumeniuk.decertonumberservicecore.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class RandomNumberJava {

    private final BigDecimal value;

    public RandomNumberJava() {
        this.value = new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2);
    }

    public BigDecimal getValue() {
        return value;
    }
}

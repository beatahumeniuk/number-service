package pl.beatahumeniuk.decertonumberservicecore.service;

import org.springframework.stereotype.Component;
import pl.beatahumeniuk.decertonumberservicecore.model.OperationType;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumber;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class Calculator<T1 extends RandomNumber, T2 extends RandomNumber> {
    private final Class<T1> randomNumberType1;
    private final Class<T2> randomNumberType2;

    private BigDecimal firstValue;
    private BigDecimal secondValue;

    public Calculator() {
        randomNumberType1 = (Class<T1>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        randomNumberType2 = (Class<T2>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        getValueByClass(randomNumberType1, randomNumberType2);

    }

    private void getValueByClass(Class<T1> firstClass, Class<T2> secondClass) {
        try {
            firstValue = (BigDecimal) firstClass.getDeclaredMethod("getRandomValue");
//            secondValue = (BigDecimal) secondClass.getDeclaredMethod("getRandomValue").invoke(secondClass);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public BigDecimal calculate(OperationType operationType) {

        switch (operationType){
            case ADDITION:
              return firstValue.add(secondValue);
            case SUBTRACT:
                return firstValue.subtract(secondValue);
            case DIVIDE:
                return firstValue != null? firstValue.divide(secondValue, 2) : null;
            case MULTIPLICATION:
                return firstValue.multiply(secondValue);
        }

        return null;
    }
}

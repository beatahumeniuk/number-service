package pl.beatahumeniuk.decertonumberservicecore.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.beatahumeniuk.decertonumberservicecore.model.OperationType;
import pl.beatahumeniuk.decertonumberservicecore.service.DBJavaCalculator;
import pl.beatahumeniuk.decertonumberservicecore.service.NumberService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class NumberResource {

    private final NumberService numberService;
    private final DBJavaCalculator dbJavaCalculator;


    @GetMapping("t")
    public BigDecimal getOne(){
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2);
    }

    @GetMapping("db")
    public BigDecimal getSum(){
        return numberService.getFromDB();
    }

//    @GetMapping("type")
//    public Method[] getOneType() {
//        return dbJavaCalculator.getRandomNumberType1().getMethods();
//    }
//
//    @GetMapping("typeAll")
//    public Object getOneTypeAll() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Method method = dbJavaCalculator.getRandomNumberType1().getMethod("getValue");
//        Object invoke = method.invoke(null);
//        return invoke;
//    }
//
//    @GetMapping("ttt")
//    public Object getTwo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        return dbJavaCalculator.getRandomNumberType2().getDeclaredMethod("getValue").invoke(null);
//
//    }

    @GetMapping("r")
    public BigDecimal result(){
       return dbJavaCalculator.calculate(OperationType.ADDITION);
    }

}

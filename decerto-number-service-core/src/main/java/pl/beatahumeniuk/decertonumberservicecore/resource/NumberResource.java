package pl.beatahumeniuk.decertonumberservicecore.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.beatahumeniuk.decertonumberservicecore.model.OperationType;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberDB;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberJava;
import pl.beatahumeniuk.decertonumberservicecore.service.NumberService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/number")
public class NumberResource {

    private final NumberService numberService;
    private final RandomNumberDB randomNumberDB;
    private final RandomNumberJava randomNumberJava;

    @GetMapping("/calculate")
    public BigDecimal calculate(){
       return numberService.calculate(randomNumberDB, randomNumberJava, OperationType.ADDITION);
    }

}

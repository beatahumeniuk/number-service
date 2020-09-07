package pl.beatahumeniuk.decertonumberservicecore.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberDB;
import pl.beatahumeniuk.decertonumberservicecore.repository.RandomNumberDBRepository;
import pl.beatahumeniuk.decertonumberservicecore.service.NumberService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class NumberResource {

    private final RandomNumberDBRepository randomNumberDBRepository;
    private final NumberService numberService;

    @GetMapping
    public List<BigDecimal> getAllFromDB() {
        return randomNumberDBRepository.findAll()
                .stream()
                .map(RandomNumberDB::getValue)
                .collect(Collectors.toList());
    }

    @GetMapping("t")
    public BigDecimal getOne(){
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2);
    }

    @GetMapping("sum")
    public BigDecimal getSum(){
        return numberService.getSum();
    }


}

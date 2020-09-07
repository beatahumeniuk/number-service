package pl.beatahumeniuk.decertonumberservicecore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberJava;
import pl.beatahumeniuk.decertonumberservicecore.repository.RandomNumberDBRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final RandomNumberDBRepository randomNumberDBRepository;

    public BigDecimal getSum() {
       return randomNumberDBRepository.findById(1L).get().getValue().add(new RandomNumberJava().getValue());
    }

}

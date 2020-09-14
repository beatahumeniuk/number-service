package pl.beatahumeniuk.decertonumberserviceclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@FeignClient(value = "number-service")
public interface NumberClientService {

    @GetMapping("/api/number/calculate")
    BigDecimal calculate();
}

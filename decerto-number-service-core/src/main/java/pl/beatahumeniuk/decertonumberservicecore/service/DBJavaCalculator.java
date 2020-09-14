package pl.beatahumeniuk.decertonumberservicecore.service;

import org.springframework.stereotype.Component;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberDB;
import pl.beatahumeniuk.decertonumberservicecore.model.RandomNumberJava;

@Component
public class DBJavaCalculator extends Calculator<RandomNumberDB, RandomNumberJava> {
}

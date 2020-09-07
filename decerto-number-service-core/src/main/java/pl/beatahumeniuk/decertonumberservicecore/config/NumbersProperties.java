package pl.beatahumeniuk.decertonumberservicecore.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "decerto")
@Data
@Component
public class NumbersProperties {

    private int dbItemsNumber;
}

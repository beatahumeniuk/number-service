package pl.beatahumeniuk.decertonumberservicecore.db.migration;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;
import pl.beatahumeniuk.decertonumberservicecore.config.NumbersProperties;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class R__insert_random_numbers extends BaseJavaMigration {

private final NumbersProperties numbersProperties;

    @Override
    public void migrate(Context context) {

        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute(prepareQuery(prepareList(numbersProperties.getDbItemsNumber())));
    }

    private String prepareQuery(List<BigDecimal> items) {
        StringBuilder query = new StringBuilder("INSERT INTO decerto.random_number_db_entity VALUES ");
        for (int i = 0; i < items.size(); i++) {
            query.append("(").append(i + 1).append(",").append(items.get(i)).append("),");
        }
        query.deleteCharAt(query.length()-1);
        query.append("SELECT setval('decerto.hibernate_sequence', ").append(items.size()).append(", true)");
        return query.toString();
    }

    private List<BigDecimal> prepareList(int itemsNumber) {
        List<BigDecimal> items = new ArrayList<>();

        for (int i = 0; i < itemsNumber; i++) {
            items.add(new BigDecimal(BigInteger.valueOf(new Random().nextInt(1000001)), 2));
        }
        return items;
    }
}

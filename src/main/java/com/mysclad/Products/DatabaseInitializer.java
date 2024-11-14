package com.mysclad.Products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            // Проверка и создание таблицы, если её нет
            String createTableSQL = "CREATE TABLE IF NOT EXISTS products ("
                    + "id BIGSERIAL PRIMARY KEY, "
                    + "productName VARCHAR(260) NOT NULL, "
                    + "productDescription VARCHAR(4099) NOT NULL, "
                    + "productPrice INTEGER NOT NULL, "
                    + "productStock VARCHAR(254) NOT NULL)";
            statement.execute(createTableSQL);
            System.out.println("Table `products` is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package edu.school21.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {

    private EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    private DataSource dataSource;

    @BeforeEach
    void init()
    {
        dataSource = builder.setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").
                addScript("data.sql").build();
    }

    @Test
    void getConnection() throws SQLException {
       Assertions.assertNotNull(dataSource.getConnection());
    }
}

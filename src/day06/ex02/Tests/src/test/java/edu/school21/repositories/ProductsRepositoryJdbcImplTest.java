package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsRepositoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "Fish", 150),
            new Product(1L, "meat chicken", 120),
            new Product(2L, "ice-cream", 43),
            new Product(3L, "Bread", 700),
            new Product(4L, "Coca-Cola", 300),
            new Product(5L, "milk", 20));

    final Product EXPECTED_FIND_BY_ID_PRODUCT =  new Product(0L, "Fish", 150);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(1L, "meat chicken", 120);
    final Product EXPECTED_SAVE_PRODUCT = new Product(6L, "new product", 120);

    private EmbeddedDatabase builder;
    private ProductsRepositoryJdbcImpl productsRepositoryJdbc;

    @BeforeEach
    void init()
    {
        builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).
                addScript("schema.sql").
                addScript("data.sql").
                build();
        productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(builder);
    }


    @Test
    void getConnect()
    {
        Assertions.assertNotNull(builder);
    }

    @Test
    void findAllTest() throws SQLException
    {
        assertEquals(productsRepositoryJdbc.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }

    @Test
    void findByIdTest() throws SQLException
    {
        assertEquals(productsRepositoryJdbc.findById(0L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void updateTest() throws  SQLException
    {
        productsRepositoryJdbc.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(productsRepositoryJdbc.findById(1L).get(), EXPECTED_UPDATED_PRODUCT);
    }

   @Test
    void testSave() throws SQLException {
        productsRepositoryJdbc.save(EXPECTED_SAVE_PRODUCT);
        Assertions.assertEquals(productsRepositoryJdbc.findById(6L).get(), EXPECTED_SAVE_PRODUCT);
    }

    @Test
    void deleteTest() throws  SQLException
    {
        productsRepositoryJdbc.delete(1L);
        assertThrows(SQLException.class, () -> productsRepositoryJdbc.findById(1L).get());
    }

    @AfterEach
    void close() {
        builder.shutdown();
    }
}

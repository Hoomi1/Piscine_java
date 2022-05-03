package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{

    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product;");
        while (resultSet.next())
            productList.add(new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3)));
        statement.close();
        resultSet.close();
        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT * FROM product WHERE identifier=" + id + ";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (!resultSet.next())
            throw new SQLException("SQLException");
        Product product = new Product(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getInt(3));
        resultSet.close();
        connection.close();
        statement.close();
        return Optional.of(product);
    }

    @Override
    public void update(Product product) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "update product set " +
                "name = " + (product.getName() == null ? null : "'" + product.getName() + "'") + "," +
                "price = " + (product.getPrice() == 0 ? 0 : product.getPrice()) +
                " where identifier = " + product.getIdentifier();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void save(Product product) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO product (name, price) VALUES ('" + product.getName() + "', "
                + product.getPrice() +");";
        Statement statement = connection.createStatement();
        statement.execute(query);
        List<Product> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        connection.close();
        statement.close();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String query = "DELETE FROM product WHERE identifier = " + id;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
    }
}

package domain.db;

import domain.model.Product;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductRepositorySQL implements ProductRepository {

    private Properties properties = new Properties();
    private String url = "jdbc:postgresql://databanken.ucll.be:51819/2TX33";

    public ProductRepositorySQL(Properties properties) {
        this.properties = properties;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Product get(String name) {
        if (name == null) {
            throw new DbException("Name can't be empty");
        }

        String sql = "Select * " +
                     "From veggie " +
                     "Where name = ? ";

        try (Connection connection = DriverManager.getConnection(url, properties); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Double price = result.getDouble("price");
                Boolean vegetarian = result.getBoolean("vegetarian");
                Product product = new Product(name, price, vegetarian);
                return product;
            }
            else {
                throw new DbException("Failed to get product");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getAll() {
        try (Connection connection = DriverManager.getConnection(url, properties); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * From veggie");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    private List<Product> createListFromResultset(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            boolean vegetarian = resultSet.getBoolean("vegetarian");
            Product product = new Product(name, price, vegetarian);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> sortProducts() {
        String sql = "Select * " +
                     "From veggie " +
                     "Order By price DESC";

        try (Connection connection = DriverManager.getConnection(url, properties); Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            return createListFromResultset(result);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getAllVegetarianProducts() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM veggie WHERE vegetarian = 'true'");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getAllNonVegetarianProducts() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM veggie WHERE vegetarian = 'false'");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }
}

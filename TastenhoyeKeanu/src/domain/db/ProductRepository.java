package domain.db;

import domain.model.Product;

import java.util.List;

public interface ProductRepository {

    Product get(String name);

    List<Product> getAll();

    List<Product> sortProducts();

    List<Product> getAllVegetarianProducts();

    List<Product> getAllNonVegetarianProducts();
}

package domain.model;

import domain.db.ProductRepository;
import domain.db.ProductRepositorySQL;
import domain.model.Product;

import java.util.List;
import java.util.Properties;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(Properties properties) {
        this.productRepository = new ProductRepositorySQL(properties);
    }

    public Product get(String name) {
        return productRepository.get(name);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> sortProducts() {
        return productRepository.sortProducts();
    }

    public List<Product> allVegetarianProducts() { return productRepository.getAllVegetarianProducts(); }

    public List<Product> allNonVegetarianProducts() {
        return productRepository.getAllNonVegetarianProducts();
    }
}

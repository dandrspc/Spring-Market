package me.dapac.market.persistence;

import me.dapac.market.persistence.crud.ProductCrudRepository;
import me.dapac.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int category){
        return productCrudRepository.findByCategoryId(category);
    }

    public Optional<List<Product>> getScarceProducts(int quantity){
        return productCrudRepository.findByStockQtyLessThanAndState(quantity, true);
    }

    public Optional<Product> getProduct(int productId){
        return productCrudRepository.findById(productId);
    }

    public Product createProduct(Product product){
        return productCrudRepository.save(product);
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}

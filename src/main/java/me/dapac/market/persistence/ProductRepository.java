package me.dapac.market.persistence;

import me.dapac.market.persistence.crud.ProductCrudRepository;
import me.dapac.market.persistence.entity.ProductTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<ProductTable> getAll() {
        return (List<ProductTable>) productCrudRepository.findAll();
    }

    public List<ProductTable> getByCategory(int category){
        return productCrudRepository.findByCategoryId(category);
    }

    public Optional<List<ProductTable>> getScarceProducts(int quantity){
        return productCrudRepository.findByStockQtyLessThanAndState(quantity, true);
    }

    public Optional<ProductTable> getProduct(int productId){
        return productCrudRepository.findById(productId);
    }

    public ProductTable createProduct(ProductTable productTable){
        return productCrudRepository.save(productTable);
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}

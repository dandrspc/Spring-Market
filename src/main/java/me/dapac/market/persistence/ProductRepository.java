package me.dapac.market.persistence;

import me.dapac.market.domain.Product;
import me.dapac.market.persistence.crud.ProductCrudRepository;
import me.dapac.market.persistence.entity.ProductTable;
import me.dapac.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements me.dapac.market.domain.repository.ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductTable> products = (List<ProductTable>) productCrudRepository.findAll();
        return (List<Product>) mapper.toProduct((ProductTable) products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductTable> products = productCrudRepository.findByCategoryId(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity){
        Optional<List<ProductTable>> products =  productCrudRepository.findByStockQtyLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId){
        return productCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        ProductTable productTable = mapper.toProductTable(product);
        return mapper.toProduct(productCrudRepository.save(productTable));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}

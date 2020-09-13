package me.dapac.market.persistence.crud;

import me.dapac.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryId(int caterogyId);
    Optional<List<Product>> findByStockQtyLessThanAndState(int stockQty, boolean state);
}

package me.dapac.market.persistence.crud;

import me.dapac.market.persistence.entity.ProductTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductTable, Integer> {
    List<ProductTable> findByCategoryId(int categoryId);
    Optional<List<ProductTable>> findByStockQtyLessThanAndState(int stockQty, boolean state);
}

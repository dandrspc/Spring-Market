package me.dapac.market.persistence.crud;

import me.dapac.market.persistence.entity.PurchaseTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseTable, Integer> {
    Optional<List<PurchaseTable>> findByClientId(String clientId);

}

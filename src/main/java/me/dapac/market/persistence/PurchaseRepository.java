package me.dapac.market.persistence;

import me.dapac.market.domain.Purchase;
import me.dapac.market.domain.repository.IPurchaseRepository;
import me.dapac.market.persistence.crud.PurchaseCrudRepository;
import me.dapac.market.persistence.entity.PurchaseTable;
import me.dapac.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseTable>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchaseTables -> mapper.toPurchases(purchaseTables));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseTable purchaseTable = mapper.toPurchaseTable(purchase);
        purchaseTable.getProducts().forEach(product -> product.setPurchaseTable(purchaseTable));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseTable));
    }
}

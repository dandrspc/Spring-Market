package me.dapac.market.persistence.mapper;

import me.dapac.market.domain.Purchase;
import me.dapac.market.persistence.entity.PurchaseTable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "products", target = "items"),
            @Mapping(source = "state", target = "active")
    })
    Purchase toPurchase(PurchaseTable purchase);
    List<Purchase> toPurchases(List<PurchaseTable> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseTable toPurchaseTable(Purchase purchase);
}

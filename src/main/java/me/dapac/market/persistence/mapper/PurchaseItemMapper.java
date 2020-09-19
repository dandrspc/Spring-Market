package me.dapac.market.persistence.mapper;

import me.dapac.market.domain.PurchaseItem;
import me.dapac.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchaseTable", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchasesId", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItem item);
}

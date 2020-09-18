package me.dapac.market.persistence.mapper;

import me.dapac.market.domain.Product;
import me.dapac.market.persistence.entity.ProductTable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "state", target = "active")
    })
    Product toProduct(ProductTable productTable);
    List<Product> toProducts(List<ProductTable> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductTable toProductTable(Product product);
}

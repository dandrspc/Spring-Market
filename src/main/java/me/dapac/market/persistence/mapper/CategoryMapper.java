package me.dapac.market.persistence.mapper;

import me.dapac.market.domain.Category;
import me.dapac.market.persistence.entity.CategoryTable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    Category toCategory(CategoryTable categoryTable);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryTable toCategoryTable(Category category);
}

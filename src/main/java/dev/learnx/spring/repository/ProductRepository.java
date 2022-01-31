package dev.learnx.spring.repository;

import dev.learnx.spring.dto.Product;
import dev.learnx.spring.publicenum.StatusEnum;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ProductRepository {
    public List<Product> loadProducts(){
        return Stream.of(
                Product.builder()
                .productName("Samsung Mobile")
                .price(BigDecimal.valueOf(10000))
                .status(StatusEnum.ACTIVE).build(),
                Product.builder()
                .productName("Nokia Mobile")
                .price(BigDecimal.valueOf(15000))
                .status(StatusEnum.ACTIVE).build(),
                Product.builder()
                .productName("iPhone 13")
                .price(BigDecimal.valueOf(25000))
                .status(StatusEnum.INACTIVE).build())
                .collect(Collectors.toList());
    }

    public long countProductByStatus(String status){
        return loadProducts().stream()
                .filter(product -> status.equalsIgnoreCase(product.getStatus().getStatus()))
                .count();
    }
}

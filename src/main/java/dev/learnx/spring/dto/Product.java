package dev.learnx.spring.dto;

import dev.learnx.spring.publicenum.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private String productName;
    private BigDecimal price;
    private StatusEnum status;
    private String sku;
}

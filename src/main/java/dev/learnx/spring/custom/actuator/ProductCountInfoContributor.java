package dev.learnx.spring.custom.actuator;

import dev.learnx.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductCountInfoContributor implements InfoContributor {
    private final ProductRepository productRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> productStatusMap = new HashMap<>();
        productStatusMap.put("active", productRepository.countProductByStatus("active"));
        productStatusMap.put("inactive", productRepository.countProductByStatus("inactive"));
        builder.withDetail("productCountByStatus", productStatusMap);
    }
}

package fc.server.palette.purchase.service;

import fc.server.palette.purchase.dto.response.ProductDto;
import fc.server.palette.purchase.entity.Purchase;
import fc.server.palette.purchase.repository.PurchaseMediaRepository;
import fc.server.palette.purchase.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMediaRepository purchaseMediaRepository;

    public List<ProductDto> getAllProducts() {
        List<Purchase> purchases = purchaseRepository.findAll();

        return purchases.stream().map(purchase ->
                ProductDto.builder()
                        .id(purchase.getId())
                        .title(purchase.getTitle())
                        .category(purchase.getCategory())
                        .endDate(purchase.getEndDate())
                        .endTime(purchase.getEndTime())
                        .price(purchase.getPrice())
                        .thumbnailUrl(purchaseMediaRepository.findById(purchase.getId()).orElse(null).getUrl()) //todo url이 null일때 예외처리
                        .hits(purchase.getHits())
                        .build()
        ).collect(Collectors.toList());
    }
}

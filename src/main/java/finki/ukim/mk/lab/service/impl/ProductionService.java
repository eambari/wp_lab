package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Production;
import finki.ukim.mk.lab.repository.ProductionRepository;
import finki.ukim.mk.lab.service.IProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService implements IProductionService {
    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }
    @Override
    public List<Production> listAll() {
        return productionRepository.findAll();
    }
}

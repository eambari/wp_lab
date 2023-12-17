package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.bootstrap.DataHolder;
import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductionRepository {
    public List<Production> findAll(){
        return DataHolder.productions;
    }
    public Optional<Production> findById(Long productionId) {
        return DataHolder.productions.stream()
                .filter(i -> i.getId().equals(productionId))
                .findFirst();
    }
}

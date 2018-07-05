package br.edu.ufcg.ccc.daca.backend.repositories;

import java.util.Optional;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufcg.ccc.daca.backend.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Collection<Product>> findAllByCategory(String category);
}

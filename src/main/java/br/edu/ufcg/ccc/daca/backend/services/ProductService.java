package br.edu.ufcg.ccc.daca.backend.services;

import java.util.Collection;
import java.util.Optional;

import br.edu.ufcg.ccc.daca.backend.entities.Product;

public interface ProductService {

	void saveProduct(Product product);

	void saveAllProducts(Collection<Product> products);

	Collection<Product> listAllProducts();

	Optional<Product> findProductById(Long id);

	Collection<Product> findProductsByCategory(String category);

	void deleteProduct(Long id);

	boolean hasProduct(Long id);
}

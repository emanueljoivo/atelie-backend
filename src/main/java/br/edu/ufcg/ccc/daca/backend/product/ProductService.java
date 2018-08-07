package br.edu.ufcg.ccc.daca.backend.product;

import java.util.Collection;
import java.util.Optional;

import br.edu.ufcg.ccc.daca.backend.product.Product;

public interface ProductService {

	Product saveProduct(Product product);

	Collection<Product> listAllProducts();

	Optional<Product> findProductById(Long id);

	Collection<Product> findProductsByCategory(String category);

	void deleteProduct(Long id);

	boolean hasProduct(Long id);
}

package br.edu.ufcg.ccc.daca.backend.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ufcg.ccc.daca.backend.entities.Product;
import br.edu.ufcg.ccc.daca.backend.services.ProductService;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<Collection<Product>> getProductByCategory(@RequestParam String category) {
		Collection<Product> productsAboveCategory = this.productService.findProductsByCategory(category);

		if (productsAboveCategory.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productsAboveCategory);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		final Long productId;

		try { productId = Long.parseLong(id); } catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

		Optional<Product> p = this.productService.findProductById(productId);

		return p.map(ResponseEntity::ok).
				orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Collection<Product>> listAllProducts() {
		Collection<Product> allProducts = this.productService.listAllProducts();

		if (allProducts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public int saveProduct(@RequestBody Product product) {

	    if (product.getId() != null) return METHOD_NOT_ALLOWED.value();

        try { this.productService.saveProduct(product); } catch (Exception e) {
			System.out.println(e.toString());
            return BAD_REQUEST.value();
        }

        return ACCEPTED.value();
	}

	@PostMapping(value = "/saveAll")
	public ResponseEntity<List<Product>> saveAllProducts(@RequestBody List<Product> products) {

		try {
			this.productService.saveAllProducts(products);
		} catch (Exception e){
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(products);
	}

	@PutMapping(value = "/update")
    public int updateProduct(@RequestBody Product product) {
        if ((product.getId() == null) ||
                (!this.productService.hasProduct(product.getId()))) {
            return NOT_FOUND.value();
        }

        try {
            this.productService.saveProduct(product);
        } catch (Exception e) { return BAD_REQUEST.value(); }

        return CREATED.value();
    }

    @DeleteMapping(value = "/delete/{id}")
    public int deleteProduct(@PathVariable String id) {
        final Long productId;

        try { productId = Long.parseLong(id); } catch (Exception e) {
            return BAD_REQUEST.value();
        }

        if (!this.productService.hasProduct(productId)) {
            return NOT_FOUND.value();
        }

        try { this.productService.deleteProduct(productId); } catch (Exception e) {
            return BAD_REQUEST.value();
        }

        return OK.value();
    }
}
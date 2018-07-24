package br.edu.ufcg.ccc.daca.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id", nullable = false)
	private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "product_description", nullable = false)
	private String description;

	@NotNull
    @Basic(optional = false)
    @Column(name = "product_category", nullable = false)
	private String category;

	public Product(){}

	public Product(Long id, String description, String category) {
		this.id = id;
	    this.description = description;
	    this.category = category;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		return id.equals(product.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	/**
	 * @return the id
	 */
	public Long getId() { return this.id; }

    /**
     * @return the description
     */
	public String getDescription() { return this.description; }

	/**
	 * @param description the name to set
	 */
	public void setDescription(String description) { this.description = description; }

    /**
     * @return the category
     */
    public String getCategory() { return this.category; }

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) { this.category = category; }
}
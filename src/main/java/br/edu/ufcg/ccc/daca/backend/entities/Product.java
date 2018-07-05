package br.edu.ufcg.ccc.daca.backend.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
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
		setId(id);
	    setDescription(description);
	    setCategory(category);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

    /**
     * @param id the id to set
     */
    public void setId(Long id) { this.id = id; }

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
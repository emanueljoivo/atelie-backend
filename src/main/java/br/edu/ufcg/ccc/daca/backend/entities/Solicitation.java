package br.edu.ufcg.ccc.daca.backend.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitations")
public class Solicitation {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@Basic(optional = false)
	private Long id;

	@NotNull
	@Basic(optional = false)
	@Column(name = "solicitation_description", nullable = false)
	private String description;

	public Solicitation(){}
	
	public Solicitation(Long id, String description) {
		setId(id);
		setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitation other = (Solicitation) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
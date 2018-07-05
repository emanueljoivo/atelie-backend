package br.edu.ufcg.ccc.daca.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.ccc.daca.backend.entities.Solicitation;

@Repository
public interface SolicitationRepository extends JpaRepository<Solicitation, Long>{}

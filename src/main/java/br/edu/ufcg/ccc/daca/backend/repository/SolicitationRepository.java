package br.edu.ufcg.ccc.daca.backend.repository;

import br.edu.ufcg.ccc.daca.backend.entity.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitationRepository extends JpaRepository<Solicitation, Long> {}

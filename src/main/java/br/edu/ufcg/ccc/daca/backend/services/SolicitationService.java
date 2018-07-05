package br.edu.ufcg.ccc.daca.backend.services;

import java.util.List;

import br.edu.ufcg.ccc.daca.backend.entities.Solicitation;

public interface SolicitationService {
	
	List<Solicitation> listAllSolicitations();
	
	Solicitation addSolicitation(Solicitation s);
}

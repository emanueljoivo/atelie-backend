package br.edu.ufcg.ccc.daca.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufcg.ccc.daca.backend.entities.Solicitation;
import br.edu.ufcg.ccc.daca.backend.repositories.SolicitationRepository;

@Service
public class SolicitationServiceImpl implements SolicitationService {
	
	@Autowired
	SolicitationRepository solicitationRepo;

	public SolicitationServiceImpl(SolicitationRepository solicitationRepo) {
		this.solicitationRepo = solicitationRepo;
	}

	@Override
	public List<Solicitation> listAllSolicitations() {
		return this.solicitationRepo.findAll();
	}

	@Override
	public Solicitation addSolicitation(Solicitation s) {
		this.solicitationRepo.save(s); return s;
	}
	
	

}

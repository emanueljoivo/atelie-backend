package br.edu.ufcg.ccc.daca.backend.solicitation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitationServiceImpl implements SolicitationService {

    private SolicitationRepository solicitationRepository;

    @Autowired
    public SolicitationServiceImpl(SolicitationRepository solicitationRepository) {
        this.solicitationRepository = solicitationRepository;
    }
}

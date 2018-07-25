package br.edu.ufcg.ccc.daca.backend.payload;

import br.edu.ufcg.ccc.daca.backend.constants.AuthEndPoints;
import br.edu.ufcg.ccc.daca.backend.constants.ProductEndPoints;
import br.edu.ufcg.ccc.daca.backend.constants.ScheduleEndPoints;
import br.edu.ufcg.ccc.daca.backend.constants.SolicitationEndPoints;

import java.util.Map;

public class EndPoints {

    private Map<String, ProductEndPoints> productUrls;

    private Map<String, SolicitationEndPoints> solicitationUrls;

    private Map<String, AuthEndPoints> authUrls;

    private Map<String, ScheduleEndPoints> scheduleUrl;

    public EndPoints(){}
}

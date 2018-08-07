package br.edu.ufcg.ccc.daca.backend.endpoint;

import br.edu.ufcg.ccc.daca.backend.auth.AuthEndPoints;
import br.edu.ufcg.ccc.daca.backend.product.ProductEndPoints;
import br.edu.ufcg.ccc.daca.backend.schedule.ScheduleEndPoints;
import br.edu.ufcg.ccc.daca.backend.solicitation.SolicitationEndPoints;

import java.util.Map;

public class EndPoints {

    private Map<String, ProductEndPoints> productUrls;

    private Map<String, SolicitationEndPoints> solicitationUrls;

    private Map<String, AuthEndPoints> authUrls;

    private Map<String, ScheduleEndPoints> scheduleUrl;

    public EndPoints(){}
}

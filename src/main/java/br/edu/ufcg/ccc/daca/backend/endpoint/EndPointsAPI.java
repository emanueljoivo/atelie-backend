package br.edu.ufcg.ccc.daca.backend.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class EndPointsAPI {

    @GetMapping("endpoints")
    public ResponseEntity<Collection<?>> getAllEndPointsUrl() {



        return null;
    }
}

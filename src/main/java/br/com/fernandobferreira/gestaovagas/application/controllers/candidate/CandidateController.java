package br.com.fernandobferreira.gestaovagas.application.controllers.candidate;

import br.com.fernandobferreira.gestaovagas.application.exceptions.UsernameFoundException;
import br.com.fernandobferreira.gestaovagas.domain.candidate.Candidate;
import br.com.fernandobferreira.gestaovagas.useCases.candidate.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;


    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Candidate candidate) {

        try {
            var jpaEntity = this.createCandidateUseCase.execute(candidate);

            return ResponseEntity
                .ok()
                .body(jpaEntity);


        } catch (UsernameFoundException e) {

            return ResponseEntity
                .badRequest()
                .body(e.getMessage());
        }
    }
}

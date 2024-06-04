package br.com.fernandobferreira.gestaovagas.application.controllers.candidate;

import br.com.fernandobferreira.gestaovagas.domain.candidate.Candidate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create( @Valid @RequestBody Candidate candidate) {
        System.out.println(candidate.toString());
    }
}

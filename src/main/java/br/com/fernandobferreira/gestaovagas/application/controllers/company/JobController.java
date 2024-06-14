package br.com.fernandobferreira.gestaovagas.application.controllers.company;

import br.com.fernandobferreira.gestaovagas.domain.company.jobs.DTOs.CreateJobDto;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.job.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> postJob(@Valid @RequestBody CreateJobDto jobDto) {

        try {
            final var res = this.createJobUseCase.execute(jobDto);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

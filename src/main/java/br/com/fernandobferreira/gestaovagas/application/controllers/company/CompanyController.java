package br.com.fernandobferreira.gestaovagas.application.controllers.company;

import br.com.fernandobferreira.gestaovagas.application.exceptions.UserFoundException;
import br.com.fernandobferreira.gestaovagas.domain.company.company.Company;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.company.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody Company company) {
        try {
            final var result = this.createCompanyUseCase.execute(company);
            return ResponseEntity.ok().body(result);
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

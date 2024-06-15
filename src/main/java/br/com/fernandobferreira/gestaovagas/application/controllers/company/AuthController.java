package br.com.fernandobferreira.gestaovagas.application.controllers.company;

import br.com.fernandobferreira.gestaovagas.domain.company.company.dto.AuthCompanyDTO;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.company.AuthCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/company/")
    public ResponseEntity<Object> authenticateCompany(@RequestBody AuthCompanyDTO company) throws Exception {
        try {
            var result = this.authCompanyUseCase.execute(company);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

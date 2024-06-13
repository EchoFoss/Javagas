package br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.company;

import br.com.fernandobferreira.gestaovagas.application.exceptions.UserFoundException;
import br.com.fernandobferreira.gestaovagas.domain.company.company.Company;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.company.CompanyEntity;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.company.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(Company company) {

        this.companyRepository
            .findByUsernameOrEmail(
                company.getUsername()
                , company.getEmail()
            )
            .ifPresent((user) -> {
                    throw new UserFoundException();
                }
            );

        return this.companyRepository.save(company.toJpaEntity());
    }
}

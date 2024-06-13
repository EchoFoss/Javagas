package br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.company.company;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.company.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
}

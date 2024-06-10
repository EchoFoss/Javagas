package br.com.fernandobferreira.gestaovagas.application.repositories.candidate;

import br.com.fernandobferreira.gestaovagas.domain.candidate.Candidate;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}

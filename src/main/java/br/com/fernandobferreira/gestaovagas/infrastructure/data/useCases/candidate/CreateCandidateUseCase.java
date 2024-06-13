package br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.candidate;

import br.com.fernandobferreira.gestaovagas.application.exceptions.UserFoundException;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.candidate.CandidateRepository;
import br.com.fernandobferreira.gestaovagas.domain.candidate.Candidate;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.candidate.CandidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(Candidate candidate) {


        this.candidateRepository
            .findByUsernameOrEmail(
                candidate.getUsername(),
                candidate.getEmail()
            )
            .ifPresent((user) -> {
                throw new UserFoundException();
            });

        var jpaEntity = candidate.toJPA();

        this.candidateRepository.save(jpaEntity);
        return jpaEntity;

    }
}

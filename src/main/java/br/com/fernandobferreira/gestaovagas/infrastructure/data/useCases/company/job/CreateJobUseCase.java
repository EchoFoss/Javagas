package br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.job;

import br.com.fernandobferreira.gestaovagas.domain.company.jobs.DTOs.CreateJobDto;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.job.JobEntity;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.company.jobs.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(CreateJobDto job) {
        final var jobEntity = job.toJpa();

        return this.jobRepository.save(jobEntity);
    }
}

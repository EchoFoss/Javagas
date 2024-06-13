package br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.company.jobs;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.job.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {


}

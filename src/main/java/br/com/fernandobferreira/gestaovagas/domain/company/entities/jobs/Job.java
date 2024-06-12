package br.com.fernandobferreira.gestaovagas.domain.company.entities.jobs;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.job.JobEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Job {
    @Length(min = 5, max = 25, message = "O nome da vaga deve ter entre (5) e (25) caracteres")
    private String name;

    @Length(min = 20, max = 255, message = "A descrição da vaga deve ter entre (20) e (255) caracteres")
    private String description;

    @Length(min = 20, max = 255, message = "A descrição da vaga deve ter entre (20) e (255) caracteres")
    private String benefits;

    @Length(max = 20, message = "A senioridade da vaga deve ter no máximo 20 caracteres")
    private String level;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private JobEntity toJpaEntity() {
        return JobEntity
            .builder()
            .name(this.name)
            .description(this.description)
            .benefits(this.benefits)
            .level(this.level)
            .build();
    }
}

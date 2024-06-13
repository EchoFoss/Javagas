package br.com.fernandobferreira.gestaovagas.domain.company.jobs.DTOs;


import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.job.JobEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record CreateJobDto(
    @Length(min = 5, max = 25, message = "O nome da vaga deve ter entre (5) e (25) caracteres")
    String name,

    @Length(min = 20, max = 255, message = "A descrição da vaga deve ter entre (20) e (255) caracteres")
    String description,
    @Length(min = 20, max = 255, message = "A descrição da vaga deve ter entre (20) e (255) caracteres")
    String benefits,
    @Length(max = 20, message = "A senioridade da vaga deve ter no máximo 20 caracteres")
    @NotBlank(message = "Esse campo é obrigatório")
    String level,
    UUID companyId
) {
    public JobEntity toJpa() {
        return JobEntity.builder()
            .name(this.name)
            .description(this.description)
            .benefits(this.benefits)
            .level(this.level)
            .companyId(this.companyId)
            .build();
    }
}

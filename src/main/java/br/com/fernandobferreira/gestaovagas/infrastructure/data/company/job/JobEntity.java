package br.com.fernandobferreira.gestaovagas.infrastructure.data.company.job;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.company.CompanyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "jobs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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


    @ManyToOne()
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;
}

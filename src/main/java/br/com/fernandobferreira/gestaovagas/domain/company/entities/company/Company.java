package br.com.fernandobferreira.gestaovagas.domain.company.entities.company;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.company.company.CompanyEntity;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    @NotBlank
    @NotNull
    private String username;

    @Email(message = "O campo [email] deve conter um email")
    @NotBlank
    @NotNull
    private String email;

    @Length(min = 10, max = 25, message = "A senha deve conter entre (10) e (25) caracteres")
    @NotBlank
    @NotNull

    private String password;

    @Nullable
    private String website;

    @Length(max = 255, message = "O tamanho máximo da decrição da empresa é de (255) caracteres")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    CompanyEntity toJpaEntity() {
        return CompanyEntity
            .builder()
            .name(this.name)
            .username(this.email)
            .email(this.email)
            .password(this.password)
            .website(this.website)
            .description(this.description)
            .createdAt(this.createdAt)
            .build();
    }
}

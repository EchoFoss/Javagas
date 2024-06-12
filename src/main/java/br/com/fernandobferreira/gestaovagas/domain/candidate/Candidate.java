package br.com.fernandobferreira.gestaovagas.domain.candidate;

import br.com.fernandobferreira.gestaovagas.infrastructure.data.candidate.CandidateEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class Candidate {
    private UUID id;
    private String nome;

    @NotBlank(message = "o campo [username] não deve estar em branco")
    @Pattern(regexp = "^\\S+$", message = "O campo [username] não deve conter espaços") // pattern para nao aceitar um username com espaco
    private String username;

    @Email(message = "O campo [email] deve conter um email válido")
    private String email;
    @Length(min = 10, max = 25, message = "A senha deve ter entre 10 e 25 caracteres")
    private String password;
    private String description;
    private String curriculum;


    public CandidateEntity toJPA() {
        return new CandidateEntity(
                this.getNome(),
                this.getUsername(),
                this.getEmail(),
                this.getPassword(),
                this.getDescription(),
                this.getCurriculum()
        );
    }
}

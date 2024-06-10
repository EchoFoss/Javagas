package br.com.fernandobferreira.gestaovagas.infrastructure.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @CreationTimestamp
    private LocalDateTime createdAt;

    public CandidateEntity(String nome, String username, String email, String password, String description, String curriculum) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.curriculum = curriculum;
    }
}

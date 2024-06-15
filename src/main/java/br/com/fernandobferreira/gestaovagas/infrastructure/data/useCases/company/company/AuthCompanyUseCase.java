package br.com.fernandobferreira.gestaovagas.infrastructure.data.useCases.company.company;

import br.com.fernandobferreira.gestaovagas.domain.company.company.dto.AuthCompanyDTO;
import br.com.fernandobferreira.gestaovagas.infrastructure.data.repositories.company.company.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyUseCase {


    @Value("${security.token.secret}")
    private String secret_key;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        final var company = this
            .companyRepository.
            findByUsername(authCompanyDTO.username())
            .orElseThrow(() -> new UsernameNotFoundException("username/password not found"));

        var passwordMatches = this
            .passwordEncoder
            .matches(
                authCompanyDTO.password(),
                company.getPassword()
            );

        if (!passwordMatches) {
            throw new AuthenticationException("Senha incorreta");
        }


        Algorithm algorithm = Algorithm.HMAC256(secret_key);

        return JWT
            .create()
            .withExpiresAt(
                Instant.now()
                    .plus(Duration.ofHours(2))
            )
            .withSubject(company.getId().toString())
            .sign(algorithm);
    }
}

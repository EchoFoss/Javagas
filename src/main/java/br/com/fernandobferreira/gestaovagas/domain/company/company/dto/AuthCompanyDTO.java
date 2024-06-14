package br.com.fernandobferreira.gestaovagas.domain.company.company.dto;


public record AuthCompanyDTO(
    String username,
    String password



) {
    public AuthCompanyDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

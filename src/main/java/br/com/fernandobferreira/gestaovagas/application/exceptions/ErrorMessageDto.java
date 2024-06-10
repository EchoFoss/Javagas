package br.com.fernandobferreira.gestaovagas.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

public record ErrorMessageDto(String message, String field){}

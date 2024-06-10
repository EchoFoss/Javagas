package br.com.fernandobferreira.gestaovagas.application.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<ErrorMessageDto>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        var dto = new ArrayList<ErrorMessageDto>();

        ex.getBindingResult().getFieldErrors().forEach(err -> {
            var message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            var newError = new ErrorMessageDto(message, err.getField());
            dto.add(newError);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}

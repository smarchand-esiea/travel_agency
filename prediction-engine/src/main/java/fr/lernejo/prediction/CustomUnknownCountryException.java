package fr.lernejo.prediction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomUnknownCountryException {

    @ExceptionHandler({ UnknownCountryException.class })
    public ResponseEntity<Object> HandleBadCountryException(
        UnknownCountryException countryException) {
        return  ResponseEntity.status(417).body(countryException.getMessage());
    }
}

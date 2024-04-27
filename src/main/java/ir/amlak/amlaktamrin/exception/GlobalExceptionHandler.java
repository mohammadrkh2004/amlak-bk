package ir.amlak.amlaktamrin.exception;

import ir.amlak.amlaktamrin.exception.impl.EstateAlreadyExists;
import ir.amlak.amlaktamrin.exception.impl.EstateDoesnotExists;
import ir.amlak.amlaktamrin.exception.impl.OwnerAlreadyExists;
import ir.amlak.amlaktamrin.exception.impl.OwnerDoesnotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EstateAlreadyExists.class)
    public ResponseEntity<ExceptionModel> estateAlreadyExistsHandler(EstateAlreadyExists exceptionMessage) {
        ExceptionModel exceptionModel = new ExceptionModel(exceptionMessage.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.badRequest().body(exceptionModel);
    }

    @ExceptionHandler(EstateDoesnotExists.class)
    public ResponseEntity<ExceptionModel> estateDoesNotExistsHandler(EstateDoesnotExists exceptionMessage) {
        ExceptionModel exceptionModel = new ExceptionModel(exceptionMessage.getMessage(), HttpStatus.NO_CONTENT.value());
        return ResponseEntity.badRequest().body(exceptionModel);
    }

    @ExceptionHandler(OwnerAlreadyExists.class)
    public ResponseEntity<ExceptionModel> ownerAlreadyExistsHandler(OwnerAlreadyExists exceptionMessage) {
        ExceptionModel exceptionModel = new ExceptionModel(exceptionMessage.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.badRequest().body(exceptionModel);
    }

    @ExceptionHandler(OwnerDoesnotExists.class)
    public ResponseEntity<ExceptionModel> ownerDoesnotExists (OwnerDoesnotExists exceptionMessage){
        ExceptionModel exceptionModel = new ExceptionModel(exceptionMessage.getMessage(), HttpStatus.NO_CONTENT.value());
        return ResponseEntity.badRequest().body(exceptionModel);
    }

}

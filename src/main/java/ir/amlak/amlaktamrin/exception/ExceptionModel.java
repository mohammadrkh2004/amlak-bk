package ir.amlak.amlaktamrin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class ExceptionModel{
    private String message;
    private int status;

}

package tk.madhavareddy.digitaldiary.presentation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvise{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex,final HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorResponse(ex.getMessage());
        errorResponse.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException maex, final HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorResponse(maex.getMessage());
        errorResponse.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMethodArgumentNotValid(ConstraintViolationException cvex, final HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorResponse(cvex.getMessage());
        errorResponse.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setRequestURI(request.getRequestURI());
        return errorResponse ;
    }

}

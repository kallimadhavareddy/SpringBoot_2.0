package tk.madhavareddy.digitaldiary.presentation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvise {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex,final HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorResponse(ex.getMessage());
        errorResponse.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotfound(MethodArgumentNotValidException maex, final HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorResponse(maex.getMessage());
        errorResponse.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

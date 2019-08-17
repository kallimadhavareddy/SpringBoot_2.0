package tk.madhavareddy.digitaldiary.presentation.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private int errorStatus;
    private String errorResponse;
    private String requestURI;
}

package com.helix.gpo.aws_service.exception;

import com.helix.gpo.aws_service.exception.types.InvalidApiKeyException;
import com.helix.gpo.aws_service.exception.types.UploadFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(InvalidApiKeyException.class)
    public ResponseEntity<ErrorResponse> handleInvalidApiKeyException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.invalid.api.key", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "UNAUTHORIZED",
                HttpStatus.UNAUTHORIZED.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UploadFailedException.class)
    public ResponseEntity<ErrorResponse> handleUploadFailedException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.upload.failed", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "BAD_REQUEST",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.internal.server.error", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        errorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}

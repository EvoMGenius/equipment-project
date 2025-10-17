package org.apatrios.exception;

import lombok.RequiredArgsConstructor;
import org.apatrios.exception.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);
    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST.value(), exception.getBindingResult().getAllErrors().stream()
                                                                                      .map(error -> messageSource.getMessage(error, Locale.getDefault()))
                                                                                      .collect(Collectors.joining(";")));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST.value(), "Некорректный формат запроса");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processRuntimeException(RuntimeException exception) {
        return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Внутренняя ошибка сервера");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDto handleNoHandlerFoundException(NoHandlerFoundException exception) {
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND.value(), "Запрашиваемый ресурс не найден");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDto handleEntityNotFound(EntityNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND.value(), messageSource.getMessage(ex.getMessage(), null, Locale.getDefault()));
    }

    private ErrorDto buildErrorResponse(Throwable e, int code, String message) {
        log.error("Handle exception:", e);
        return new ErrorDto(code, message);
    }
}
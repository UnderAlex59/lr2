package ru.zverev.lr2.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import ru.zverev.lr2.exception.UnsupportedCodeException;
import ru.zverev.lr2.exception.ValidationFailedException;
import ru.zverev.lr2.model.*;
import ru.zverev.lr2.service.ValidationService;

public class RequestValidationUtils {
    public static ResponseEntity<Response> validate(
            BindingResult bindingResult,
            ValidationService validationService,
            Request request,
            Response response
    )
    {
        ResponseEntity<Response> responseEntity = null;
        try {
            validationService.isValid(bindingResult, request);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

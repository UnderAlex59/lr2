package ru.zverev.lr2.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zverev.lr2.exception.UnsupportedCodeException;
import ru.zverev.lr2.exception.ValidationFailedException;
import ru.zverev.lr2.model.*;
import ru.zverev.lr2.service.ModifyRequestService;
import ru.zverev.lr2.service.ModifyResponseService;
import ru.zverev.lr2.service.ModifySourceRequestService;
import ru.zverev.lr2.service.ValidationService;

import java.util.Comparator;
import java.util.List;

@RestController
@Slf4j
public class MyController {

    private final ValidationService validationService;

    private final ModifyResponseService modifyResponseService;

    private final List<ModifyRequestService> modifyRequestServices;

    @Autowired
    public MyController(
            ValidationService validationService,
            @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
            List<ModifyRequestService> modifyRequestServices
    ) {
        modifyRequestServices.sort(Comparator.comparingInt(ModifyRequestService::getOrder));
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestServices = modifyRequestServices;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        modifyResponseService.modify(response);
        try {
            validationService.isValid(bindingResult, request);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.info("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Unknown exception");
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(response);
        modifyRequestServices.forEach(x -> x.modify(request));
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}

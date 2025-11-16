package ru.zverev.lr2.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.model.Response;
import ru.zverev.lr2.service.AnnualBonusService;
import ru.zverev.lr2.service.ModifyRequestService;
import ru.zverev.lr2.service.ModifyResponseService;
import ru.zverev.lr2.service.ValidationService;
import ru.zverev.lr2.util.DecimalRoundUtils;
import ru.zverev.lr2.util.RequestValidationUtils;
import ru.zverev.lr2.util.ResponseUtils;

@RestController
@Slf4j
public class MyController {

    private final ValidationService validationService;

    private final ModifyResponseService modifyResponseService;

    private final ModifyRequestService modifyRequestService;

    private final AnnualBonusService annualBonusService;

    @Autowired
    public MyController(
            ValidationService validationService,
            @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
            ModifyRequestService modifyRequestService,
            AnnualBonusService annualBonusService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.annualBonusService = annualBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = ResponseUtils.getPrefillResponse(request);
        ResponseEntity<Response> responseEntity = RequestValidationUtils.validate(
                bindingResult,
                validationService,
                request,
                response
        );
        log.info("response: {}", response);

        modifyRequestService.modify(request);
        response.setAnnualBonus(
                DecimalRoundUtils.roundWithPrecision(
                        annualBonusService.calculate(request),
                        2
                )
        );
        return responseEntity == null ?
                new ResponseEntity<>(
                        modifyResponseService.modify(response),
                        HttpStatus.OK
                ) :
                responseEntity;
    }
}

package ru.zverev.lr2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.zverev.lr2.exception.UnsupportedCodeException;
import ru.zverev.lr2.exception.ValidationFailedException;
import ru.zverev.lr2.model.Request;

@Service
@Slf4j
public class RequestValidationService implements ValidationService{

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            log.error("Validation exception: {}", bindingResult.getFieldError());
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }

    @Override
    public void isValid(BindingResult bindingResult, Request request) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            log.error("Validation exception: {}", bindingResult.getFieldError());
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
        if (request.getUid().equals("123")) {
            log.error("Unsupported operation: {uid can't be equals 123}");
            throw new UnsupportedCodeException("uid не может быть равен 123");
        }
    }
}

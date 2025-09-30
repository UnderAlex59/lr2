package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.zverev.lr2.exception.UnsupportedCodeException;
import ru.zverev.lr2.exception.ValidationFailedException;
import ru.zverev.lr2.model.Request;

@Service
public class RequestValidationService implements ValidationService{

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }

    @Override
    public void isValid(BindingResult bindingResult, Request request) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
        if (request.getUid().equals("123")) {
            throw new UnsupportedCodeException("uid не может быть равен 123");
        }
    }
}

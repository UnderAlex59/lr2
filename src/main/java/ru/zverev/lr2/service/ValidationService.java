package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.zverev.lr2.exception.UnsupportedCodeException;
import ru.zverev.lr2.exception.ValidationFailedException;
import ru.zverev.lr2.model.Request;

@Service
public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;

    void isValid(BindingResult bindingResult, Request request) throws ValidationFailedException, UnsupportedCodeException;
}

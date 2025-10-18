package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}

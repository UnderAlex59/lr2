package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);

    int getOrder();
}

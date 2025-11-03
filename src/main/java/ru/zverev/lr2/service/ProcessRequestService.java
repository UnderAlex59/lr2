package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;

@Service
public interface ProcessRequestService {
    void process(Request request);
}

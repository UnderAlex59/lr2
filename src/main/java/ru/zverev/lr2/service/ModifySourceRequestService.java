package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;

@Service
public class ModifySourceRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        request.setSource("feedback");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

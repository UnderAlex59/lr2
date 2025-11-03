package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.util.DateTimeUtil;

import java.util.Date;

@Service
public class ModifySystemTimeRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Position;
import ru.zverev.lr2.model.Request;

@Service
public interface AnnualBonusService {
    Double calculate(Request request);
}

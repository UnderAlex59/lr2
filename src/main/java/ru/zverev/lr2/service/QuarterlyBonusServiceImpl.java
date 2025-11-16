package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.util.DateTimeUtil;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {
    @Override
    public Double calculate(Request request) {
        return request.getPosition().getIsManager() ? request.getSalary() *
                request.getBonus() *
                DateTimeUtil.getDaysInQuarter() *
                request.getPosition().getPositionCoefficient() /
                request.getWorkDays() : 0;
    }
}

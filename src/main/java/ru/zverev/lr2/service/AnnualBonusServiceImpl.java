package ru.zverev.lr2.service;

import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.util.DateTimeUtil;

import java.util.Date;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public Double calculate(Request request) {
        return request.getSalary() *
                request.getBonus() *
                DateTimeUtil.getDaysInYear() *
                request.getPosition().getPositionCoefficient() /
                request.getWorkDays();
    }
}

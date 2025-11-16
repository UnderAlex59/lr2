package ru.zverev.lr2.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zverev.lr2.model.Position;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.model.Systems;
import ru.zverev.lr2.util.DateTimeUtil;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuarterlyBonusServiceImplTest {

    @Test
    void calculate() {
        //given
        Position position = Position.HR;
        Double bonus = 2.0;
        Integer workDays = 243;
        Double salary = 100000.0;

        Request request = Request.builder()
                .uid("12")
                .operationUid("30")
                .systemName(Systems.CRM)
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .source("Test")
                .position(position)
                .salary(salary)
                .bonus(bonus)
                .workDays(workDays)
                .build();

        //when
        Double result = new QuarterlyBonusServiceImpl().calculate(request);

        //then
        Double expectedResult = 89876.54320987655;
        assertEquals(expectedResult, result);

        //given
        Position position2 = Position.DEV;
        Double bonus2 = 2.0;
        Integer workDays2 = 243;
        Double salary2 = 100000.0;

        Request request2 = Request.builder()
                .uid("12")
                .operationUid("30")
                .systemName(Systems.CRM)
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .source("Test")
                .position(position2)
                .salary(salary2)
                .bonus(bonus2)
                .workDays(workDays2)
                .build();

        //when
        Double result2 = new QuarterlyBonusServiceImpl().calculate(request2);

        //then
        Double expectedResul2t = 0.0;
        assertEquals(expectedResul2t, result2);
    }
}
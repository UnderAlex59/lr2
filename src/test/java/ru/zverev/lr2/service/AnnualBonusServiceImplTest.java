package ru.zverev.lr2.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zverev.lr2.model.Position;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.model.Systems;
import ru.zverev.lr2.util.DateTimeUtil;

import java.util.Date;
import java.util.logging.SimpleFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnnualBonusServiceImplTest {

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
        Double result = new AnnualBonusServiceImpl().calculate(request);

        //then
        Double expectedResult = 360493.8271604938;
        assertEquals(expectedResult, result);
    }
}
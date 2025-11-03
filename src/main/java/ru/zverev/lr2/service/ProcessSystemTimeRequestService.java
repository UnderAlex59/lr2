package ru.zverev.lr2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.util.DateTimeUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@Slf4j
public class ProcessSystemTimeRequestService implements ProcessRequestService {
    @Override
    public void process(Request request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        Date inputRequestDate;
        try {
            inputRequestDate = dateFormat.parse(request.getSystemTime());
            Long dateDiff = date.getTime() - inputRequestDate.getTime();
            log.info("Время от получения запроса сервисам 1 до получения модифицированного запроса сервисом два прошло  " + dateDiff + " мс");
        } catch (ParseException e) {
            log.error("Неверный формат системного времени: " + e.getMessage());
        }
    }
}

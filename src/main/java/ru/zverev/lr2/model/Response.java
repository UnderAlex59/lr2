package ru.zverev.lr2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    /** Уникальный идентификатор сообщение */
    private String uid;
    /** Уникальный идентификатор операции */
    private String operationUid;
    /** Время создания сообщения */
    private String systemTime;
    /** Код ответа */
    private Codes code;
    /** Код ошибки */
    private ErrorCodes errorCode;
    /** Сообщение ошибки */
    private ErrorMessages errorMessage;
    /** Годовая премия */
    private Double annualBonus;
}

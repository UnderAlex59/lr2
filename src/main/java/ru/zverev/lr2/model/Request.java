package ru.zverev.lr2.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /** Уникальный идентификатор сообщение */
    @NotBlank
    @Size(max = 32)
    private String uid;

    /** Уникальный идентификатор операции */
    @NotBlank
    @Size(max = 32)
    private String operationUid;

    /** Имя системы отправителя */
    private Systems systemName;

    /** Время создания сообщения */
    @NotBlank
    private String systemTime;

    /** Наименование ресурса */
    private String source;

    /** Наименование поизиции работника */
    private Position position;

    /** Зарплата работника */
    private Double salary;

    /** Бонкус к ЗП работнкиа */
    private Double bonus;

    /** Кол-во отработанных дней*/
    private Integer workDays;

    /** Уникальный идентификатор коммуникации */
    @NotNull
    @Min(1)
    @Max(100000)
    private int communicationId;

    /** Уникальный идентификатор шаблона */
    private int templateId;

    /** Код продукта */
    private int productCode;

    /** Смс код */
    private int smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid=" + uid + '\'' +
                ", operationUid=" + operationUid + '\'' +
                ", systemName=" + systemName + '\'' +
                ", systemTime=" + systemTime + '\'' +
                ", source=" + source + '\'' +
                ", communicationId=" + communicationId + '\'' +
                ", templateId=" + templateId + '\'' +
                ", productCode=" + productCode + '\'' +
                ", smsCode=" + smsCode +
                "}";
    }
}

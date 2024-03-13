package org.talent.talent_pay.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
public class TalentResponse<T> {
    private String message;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private LocalDateTime date;
    private T data;

    public TalentResponse (T data, String message, HttpStatus httpStatus){
        this.data = data;
        this.message = message;
        this.httpStatusCode = httpStatus.value();
        this.httpStatus = httpStatus;
        this.date = LocalDateTime.now();
    }
}

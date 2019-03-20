package com.finalYearProject.meetYourMentor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Meet implements Serializable {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sentDateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date acceptedDateTime;

    private String type;

    private String reason;

    private String venue;

    private Long studentId;

    private Long lecturerId;
}

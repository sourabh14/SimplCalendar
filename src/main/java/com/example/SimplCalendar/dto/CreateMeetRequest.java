package com.example.SimplCalendar.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CreateMeetRequest {
    private int userId;
    private String title;
    private List<Integer> inviteeUserIds;
    private Date startTime;
    private Date endTime;
    private String venue;
    private String description;
    private Boolean sendEmailToInvitees;
    private Integer meetNotificationReminderTime;
}

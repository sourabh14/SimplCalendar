package com.example.SimplCalendar.entity;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Meet {
    private String title;
    private List<User> inviteeUser;
    private Date startTime;
    private Date endTime;
    private String venue;
    private String description;
    private Boolean sendEmailToInvitees;
    private Integer meetNotificationReminderTime;
}

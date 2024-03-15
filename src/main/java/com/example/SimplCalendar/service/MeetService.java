package com.example.SimplCalendar.service;

import com.example.SimplCalendar.dto.CreateMeetRequest;
import com.example.SimplCalendar.entity.Meet;

public interface MeetService {
    void scheduleMeet(CreateMeetRequest request);

    Meet getMeetById(Integer id);
}

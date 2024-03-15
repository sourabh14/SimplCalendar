package com.example.SimplCalendar.service.impl;

import java.util.List;

import com.example.SimplCalendar.dto.CreateMeetRequest;
import com.example.SimplCalendar.entity.Meet;
import com.example.SimplCalendar.entity.User;
import com.example.SimplCalendar.repository.MeetRepository;
import com.example.SimplCalendar.repository.UserRepository;
import com.example.SimplCalendar.service.MeetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MeetServiceImpl implements MeetService {
    private final UserRepository userRepository;
    private final MeetRepository meetRepository;

    @Override
    public void scheduleMeet(CreateMeetRequest request) {
        Meet meet = Meet.builder()
                .title(request.getTitle())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .venue(request.getVenue())
                .description(request.getDescription())
                .sendEmailToInvitees(request.getSendEmailToInvitees())
                .meetNotificationReminderTime(request.getMeetNotificationReminderTime())
                .build();

        List<User> inviteeUsers = userRepository.getUsersByIds(request.getInviteeUserIds());
        meet.setInviteeUser(inviteeUsers);

        // Persist meet entity
        meetRepository.save(meet);
    }

    @Override
    public Meet getMeetById(Integer id) {
        return meetRepository.getMeetById(id);
    }
}

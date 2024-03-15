package com.example.SimplCalendar.controller;

import com.example.SimplCalendar.dto.CreateMeetRequest;
import com.example.SimplCalendar.entity.Meet;
import com.example.SimplCalendar.service.MeetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calendar/meet")
@AllArgsConstructor
@Slf4j
public class CalendarController {
    private final MeetService meetService;

    @PostMapping
    public ResponseEntity<String> createMeet(@RequestBody CreateMeetRequest request) {
        log.info("Request: " + request);
        meetService.scheduleMeet(request);
        return ResponseEntity.ok("Meeting " + request.getTitle() + " has been scheduled");
    }

    @GetMapping("{id}")
    public ResponseEntity<Meet> getMeetById(@PathVariable("id") Integer id) {
        log.info("id: " + id);
        return ResponseEntity.ok(meetService.getMeetById(id));
    }

}

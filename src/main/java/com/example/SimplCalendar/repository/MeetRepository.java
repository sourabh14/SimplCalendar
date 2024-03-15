package com.example.SimplCalendar.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.SimplCalendar.entity.Meet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MeetRepository {
    private Map<Integer, Meet> idToMeet;
    private Integer meetCount;

    public MeetRepository() {
        idToMeet = new HashMap<>();
        meetCount = 0;
    }

    public void save(Meet meet) {
        idToMeet.put(meetCount, meet);
        log.info("Meet saved with id: " + meetCount);
        meetCount++;
    }

    public Meet getMeetById(Integer id) {
        log.info("idToMeet: " + idToMeet);
        log.info("meet: " + idToMeet.get(id));
        return idToMeet.get(id);
    }
}

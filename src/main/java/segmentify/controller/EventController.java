package segmentify.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import segmentify.annotation.ValidateEventRequest;
import segmentify.dto.EventDto;
import segmentify.response.EventResponse;
import segmentify.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final EventService eventService;

    @PostMapping("/add/events/v1.json")
    public EventResponse acceptEvent(@RequestBody @Valid @ValidateEventRequest List<EventDto> eventList, @RequestParam String apiKey) {
        log.info("eventList : {}", eventList);
        log.info("apiKey : {}", apiKey);
        return eventService.acceptEvent(eventList, apiKey);
    }
}

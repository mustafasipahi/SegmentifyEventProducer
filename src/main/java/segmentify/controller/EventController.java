package segmentify.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import segmentify.annotation.ValidateEventRequest;
import segmentify.response.EventResponse;
import segmentify.service.EventService;

import javax.validation.Valid;
import java.util.Set;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final EventService eventService;

    @PostMapping("/add/events/v1.json")
    public EventResponse acceptEvent(
            @RequestBody
            @ValidateEventRequest
            Set<@Valid Object> eventSet, @RequestParam String apiKey) {
        log.info("eventSet : {}", eventSet);
        log.info("apiKey : {}", apiKey);
        return eventService.acceptEvent(eventSet, apiKey);
    }
}

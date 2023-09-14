package segmentify.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import segmentify.request.EventRequest;
import segmentify.response.EventResponse;
import segmentify.service.EventService;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class EventController {

    private final EventService eventService;

    @PostMapping("/add/events/v1.json")
    public EventResponse acceptEvent(@RequestBody @Valid EventRequest eventRequest, @RequestParam String apiKey) {
        log.info("eventRequest : {}", eventRequest.toString());
        log.info("apiKey : {}", apiKey);
        eventRequest.setApiKey(apiKey);
        return eventService.acceptEvent(eventRequest);
    }
}

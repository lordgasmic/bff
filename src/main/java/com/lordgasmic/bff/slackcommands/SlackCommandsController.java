package com.lordgasmic.bff.slackcommands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Validated
@Slf4j
public class SlackCommandsController {

    private SlackCommandsClient client;

    public SlackCommandsController(SlackCommandsClient client) {
        this.client = client;
    }

    @PostMapping(value = "/api/v1/slack-commands/notion-scanner", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object notionScanner(@RequestBody String request) {
        //    public Object notionScanner(@RequestBody MultiValueMap<String, Object> request) {
        //        log.info(request.keySet().toString());
        log.info(request);
        return client.notionScanner(Map.of("content-type", "application/x-www-form-urlencoded"), null);
    }
}

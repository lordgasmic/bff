package com.lordgasmic.bff.slackcommands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Object notionScanner(@RequestHeader final Map<String, String> headers, @RequestParam MultiValueMap<String, String> request) {
        log.info(request.get("text").toString());
        String contentType = headers.get("content-type");
        return client.notionScanner(Map.of("content-type", contentType), request);
    }
}
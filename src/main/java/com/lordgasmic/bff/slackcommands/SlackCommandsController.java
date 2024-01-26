package com.lordgasmic.bff.slackcommands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @PostMapping("/api/v1/slack-commands/notion-scanner")
    public Object notionScanner(@RequestHeader final Map<String, String> headers, SlackRequest request) {
        log.info(request.getCommand());
        String contentType = headers.get("content-type");
        return client.notionScanner(Map.of("content-type", contentType), request.convertToFormData());
    }
}

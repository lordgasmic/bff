package com.lordgasmic.bff.slackcommands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
public class SlackCommandsController {

    private SlackCommandsClient client;

    public SlackCommandsController(SlackCommandsClient client) {
        this.client = client;
    }

    @PostMapping("/api/v1/slack-commands/notion-scanner")
    public Object notionScanner() {
        return client.notionScanner();
    }
}

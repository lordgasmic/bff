package com.lordgasmic.bff.slackcommands;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "slack-commands", url = "${slack-commands.url}")
public interface SlackCommandsClient {

    @PostMapping(value = "/api/v1/slack-commands/notion-scanner", headers = {""})
    Object notionScanner();
}

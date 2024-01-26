package com.lordgasmic.bff.slackcommands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;

import static javax.xml.crypto.dsig.SignatureMethod.HMAC_SHA256;

@RestController
@Validated
@Slf4j
public class SlackCommandsController {

    private static final String SLACK_SIGNING_SECRET = "7dfc14b2e7810c268d2ef565878266d5";

    private SlackCommandsClient client;

    public SlackCommandsController(SlackCommandsClient client) {
        this.client = client;
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private static String calculateHMAC(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);
        return toHexString(mac.doFinal(data.getBytes()));
    }

    private static void verifyRequest(String signature, String request) throws NoSuchAlgorithmException, InvalidKeyException {
        String hmac = calculateHMAC(request, SLACK_SIGNING_SECRET);
        log.info(hmac);
        log.info(signature);
    }

    @PostMapping(value = "/api/v1/slack-commands/notion-scanner", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object notionScanner(@RequestHeader final Map<String, String> headers,
                                @RequestBody String request) throws NoSuchAlgorithmException, InvalidKeyException {
        verifyRequest(headers.get("x-slack-signature"), request);
        log.info(request);
        return client.notionScanner(Map.of("content-type", "application/x-www-form-urlencoded"), null);
    }

}

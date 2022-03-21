package com.lordgasmic.bff.login;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DomController {

    @GetMapping(value = "/api/v1/dom", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String indexAsDom() {
        return "<html><body>hi</body></html>";
    }
}

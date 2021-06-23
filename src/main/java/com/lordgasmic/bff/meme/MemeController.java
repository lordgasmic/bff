package com.lordgasmic.bff.meme;

import com.lordgasmic.bff.meme.model.CreateMemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequestRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class MemeController {

    private final MemeService service;

    public MemeController(final MemeService service){
        this.service = service;
    }

    @GetMapping("/api/v1/memes/all")
    public Object getAllMemes(){
        return service.getAllMemes();
    }

    @GetMapping("/api/v1/memes/tag/$1")
    public Object getMemes(@RequestParam String tag){
        return service.getMemes(tag);
    }

    @PutMapping("/api/v1/meme")
    public void addMeme(@RequestBody CreateMemeRequest request) {
        service.addMeme(request);
    }

    @PutMapping(value = "/api/v1/memes/request")
    public void addMemeRequest(@RequestBody MemeRequestRequest request){
        service.addMemeRequest(request);
    }
}
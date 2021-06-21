package com.lordgasmic.bff.meme;

import com.lordgasmic.bff.meme.model.CreateMemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequestRequest;
import com.lordgasmic.bff.meme.model.MemeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name="meme-client", url = "${meme-service.url}")
public interface MemeClient {

    @GetMapping(value="/api/v1/memes/all", headers = {""})
    List<MemeResponse> getAllMemes();

    @GetMapping(value="/api/v1/memes/tag", headers = {""})
    List<MemeResponse> getMemes(MemeRequest request);

    @PutMapping(value = "/api/v1/meme", headers = {""})
    Object addMeme(CreateMemeRequest request);

    @PutMapping(value = "/api/v1/memes/request")
    Object addMemeRequest(MemeRequestRequest request);
}

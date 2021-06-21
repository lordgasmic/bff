package com.lordgasmic.bff.meme;

import com.lordgasmic.bff.meme.model.CreateMemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequest;
import com.lordgasmic.bff.meme.model.MemeRequestRequest;
import com.lordgasmic.bff.meme.model.MemeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {

    private final MemeClient client;

    public MemeService(final MemeClient client){
        this.client = client;
    }

    public List<MemeResponse> getAllMemes() {
        return client.getAllMemes();
    }

    public List<MemeResponse> getMemes(MemeRequest request) {
        return client.getMemes(request);
    }

    public void addMeme(CreateMemeRequest request) {
        client.addMeme(request);
    }

    public void addMemeRequest(MemeRequestRequest request) {
        client.addMemeRequest(request);
    }
}

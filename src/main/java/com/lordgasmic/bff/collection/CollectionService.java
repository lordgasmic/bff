package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.WineFriendsRequest;
import com.lordgasmic.bff.collection.model.WineNoteRequest;
import com.lordgasmic.bff.collection.model.WineRatingRequest;
import com.lordgasmic.bff.collection.model.WineRequest;
import com.lordgasmic.bff.collection.model.WineryRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionClient client;

    public CollectionService(final CollectionClient client) {
        this.client = client;
    }

    public List<Object> getWineries() {
        return client.getWineries();
    }

    public Object getWineryById(final String id) {
        return client.getWineryById(id);
    }

    public Object getWines(final String wineId, final String wineryId) {
        return client.getWines(wineId, wineryId);
    }

    public Object getWineNotes(final String user, final Integer wineId) {
        return client.getWineNotes(user, wineId);
    }

    public Object getWineRating(final String user, final Integer wineId) {
        return client.getWineRating(user, wineId);
    }

    public Object addWine(final WineRequest wineRequest) {
        return client.addWine(wineRequest);
    }

    public Object addWinery(final WineryRequest wineryRequest) {
        return client.addWinery(wineryRequest);
    }

    public Object addWineNotes(final List<WineNoteRequest> wineNoteRequests) {
        return client.addWineNotes(wineNoteRequests);
    }

    public Object addWineRating(final WineRatingRequest request) {
        return client.addWineRating(request);
    }

    public Object getWineFriends(final WineFriendsRequest request) {
        return client.getWineRatingByUsersByWineId(request);
    }

    public Object addWineImage(final MultipartFile imageFile) {
        return client.addWineImage(imageFile);
    }
}

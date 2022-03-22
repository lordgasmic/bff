package com.lordgasmic.bff.dom;

import com.lordgasmic.bff.collection.CollectionService;
import com.lordgasmic.bff.dom.model.WineNoteOutput;
import com.lordgasmic.bff.dom.model.WineResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Controller
public class DomController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CollectionService collectionService;


    @GetMapping(value = "/dom/v1/hi", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String indexAsDom() {
        return "<html><body>hi</body></html>";
    }

    @GetMapping(value = "/dom/v1/wine/1", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String wineAsDom() {
        final CompletableFuture<String> wineFuture = CompletableFuture.supplyAsync(() -> collectionService.getWines("1", null))
                                                                      .thenApply(response -> (WineResponse) response)
                                                                      .thenApply(WineResponse::getName);
        final CompletableFuture<String> wineRatingFuture = CompletableFuture.supplyAsync(() -> collectionService.getWineRating("lordgasmic", 1))
                                                                            .thenApply((responseList) -> responseList.stream()
                                                                                                                     .map(response -> StringUtils.replace(
                                                                                                                             resourceService.getHtml()
                                                                                                                                            .get("li"),
                                                                                                                             "{{data}}",
                                                                                                                             response.formatRating()))
                                                                                                                     .collect(Collectors.joining()));
        final CompletableFuture<String> wineNotesFuture = CompletableFuture.supplyAsync(() -> collectionService.getWineNotes("lordgasmic", 1))
                                                                           .thenApply((response) -> response.getWineNotes()
                                                                                                            .stream()
                                                                                                            .sorted(Comparator.comparing(
                                                                                                                    WineNoteOutput::getOrdinal))
                                                                                                            .map(output -> StringUtils.replace(
                                                                                                                    resourceService.getHtml()
                                                                                                                                   .get("li"),
                                                                                                                    "{{data}}",
                                                                                                                    output.getNote()))
                                                                                                            .collect(Collectors.joining()));

        final String wineName = wineFuture.join();
        final String wineRating = wineRatingFuture.join();
        final String wineNotes = wineNotesFuture.join();

        String wineHtml = resourceService.getHtml().get("wine");
        wineHtml = StringUtils.replace(wineHtml, "{{wine-name}}", wineName);
        wineHtml = StringUtils.replace(wineHtml, "{{wine-rating}}", wineRating);
        wineHtml = StringUtils.replace(wineHtml, "{{wine-notes}}", wineNotes);

        String html = resourceService.getHtml().get("index");
        html = StringUtils.replace(html, "{{header}}", resourceService.getHtml().get("wine-header"));
        html = StringUtils.replace(html, "{{body}}", wineHtml);

        return html;
    }
}

package com.darkvibe.services;

import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class FilmService {

    private static String API_LINK_KEY_WORD = "https://kinopoiskapiunofficial.tech/api/v2.1/films/search-by-keyword?";
    private static String API_KEY = "fa0f29dc-8b78-4097-a795-db25f9022351";

    public String getFilmListByKeyWord(String keyword, Long page) throws IOException, InterruptedException {
        String request_body = "keyword=" + keyword +
                "&page=" + page;
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                URI.create(API_LINK_KEY_WORD + request_body))
                .headers("accept", "application/json", "X-API-KEY", API_KEY)
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}

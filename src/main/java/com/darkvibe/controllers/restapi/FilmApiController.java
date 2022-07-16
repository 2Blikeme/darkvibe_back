package com.darkvibe.controllers.restapi;

import com.darkvibe.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmApiController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/film_by_keyword/keyword={keyword}&page={page}")
    public String getFilmByKeyWord(@PathVariable String keyword, @PathVariable Long page) {
        try {
            return filmService.getFilmListByKeyWord(keyword, page);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

    @GetMapping("/films/top/type={top}&page={page}")
    public String getFilmTop(@PathVariable String top, @PathVariable int page) {
        try {
            return filmService.getFilmListTop(top, page);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

}

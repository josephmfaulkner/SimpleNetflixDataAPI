package com.josephmfaulkner.simplenetflixapi.show;

import com.josephmfaulkner.simplenetflixapi.show.data.Show;
import com.josephmfaulkner.simplenetflixapi.show.data.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    @GetMapping("/show")
    public Optional<Show> getShow() {
        Optional<Show> fetchedShow = showRepository.findById("tm84618");
        return fetchedShow;
    }

}
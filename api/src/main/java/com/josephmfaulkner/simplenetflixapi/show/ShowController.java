package com.josephmfaulkner.simplenetflixapi.show;

import com.josephmfaulkner.simplenetflixapi.show.data.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/showbytitle/{show_title}")
    public List<Show> getShowByTitle(@PathVariable String show_title) {

        return showService.getShowByTitle(show_title);

    }

    @GetMapping("/showbyactorname/{actor_name}")
    public List<Show> getByActorName(@PathVariable String actor_name) {

        return showService.getShowByActorName(actor_name);

    }

}
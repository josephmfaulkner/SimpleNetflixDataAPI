package com.josephmfaulkner.simplenetflixapi.show;

import com.josephmfaulkner.simplenetflixapi.show.data.Show;
import com.josephmfaulkner.simplenetflixapi.show.data.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShowByTitle(String title) {
        List<Show> showsFound = showRepository.findByTitle(title);
        return showsFound;
    }

    public List<Show> getShowByActorName(String actor_name) {
        return showRepository.findByActorName(actor_name);
    }
}

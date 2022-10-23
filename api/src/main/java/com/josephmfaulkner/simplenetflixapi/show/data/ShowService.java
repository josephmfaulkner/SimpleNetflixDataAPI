package com.josephmfaulkner.simplenetflixapi.show.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShowByTitle(String title)
    {
        List<Show> showsFound = showRepository.findByTitle(title);
        return showsFound;
    }

}

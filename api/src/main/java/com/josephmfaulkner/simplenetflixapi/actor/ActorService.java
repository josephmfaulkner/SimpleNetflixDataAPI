package com.josephmfaulkner.simplenetflixapi.actor;

import com.josephmfaulkner.simplenetflixapi.actor.data.Actor;
import com.josephmfaulkner.simplenetflixapi.actor.data.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getActorsByShowTitle(String showTitle) {

        return actorRepository.findByShowTitle(showTitle);

    }

}

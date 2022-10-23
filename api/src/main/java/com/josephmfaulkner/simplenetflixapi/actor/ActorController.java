package com.josephmfaulkner.simplenetflixapi.actor;

import com.josephmfaulkner.simplenetflixapi.actor.data.Actor;
import com.josephmfaulkner.simplenetflixapi.actor.data.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actor")
    public Optional<Actor> getActor() {
        Optional<Actor> resultActor = actorRepository.findById(3748);
        return resultActor;
    }

}

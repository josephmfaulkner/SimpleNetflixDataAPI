package com.josephmfaulkner.simplenetflixapi.actor;

import com.josephmfaulkner.simplenetflixapi.actor.data.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actorsbyshowtitle/{show_title}")
    public List<Actor> getActorsByShowTitle(@PathVariable String show_title) {

        return actorService.getActorsByShowTitle(show_title);

    }

}

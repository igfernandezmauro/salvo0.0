package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")
    public Map<String, Object> getGames(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("games", gameRepository.findAll().stream().map(Game::getInfo).collect(toList()));
        return dto;
    }

    @RequestMapping("/game_view/{nn}")
    public Map<String, Object> getGameViews(@PathVariable long nn){
        Optional<GamePlayer> gp = gamePlayerRepository.findById(nn);
        if(gp.isPresent()){
            return gp.get().getGame().getInfo(gp.get());
        }
        else{
            return null;
        }
    }
}

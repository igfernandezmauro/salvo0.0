package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<GamePlayer> games;

    public Player(){
    }

    public Player(String _userName){
        this.userName = _userName;
    }

    public long getId() {
        return this.id;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String _userName){
        this.userName = _userName;
    }

    public void addGame(GamePlayer gamePlayer){
        games.add(gamePlayer);
    }

    public List<Game> getGames(){
        return games.stream().map(GamePlayer::getGame).collect(toList());
    }

    public Map<String, Object> getInfo(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("email", getUserName());
        return dto;
    }
}

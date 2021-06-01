package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date creationDate;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<GamePlayer> players;

    public Game(){
    }

    public Game(Date _creationDate){
        this.creationDate = _creationDate;
    }

    public long getId() {
        return this.id;
    }

    public Date getCreationDate(){
        return this.creationDate;
    }

    public void setCreationDate(Date _creationDate){
        this.creationDate = _creationDate;
    }

    public void addPlayer(GamePlayer gamePlayer){
        players.add(gamePlayer);
    }

    public List<Player> getPlayers(){
        return players.stream().map(GamePlayer::getPlayer).collect(toList());
    }

    public List<GamePlayer> getGamePlayers(){
        return new ArrayList<>(this.players);
    }

    public Map<String, Object> getInfo(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("created", getCreationDate());
        dto.put("gamePlayers", getGamePlayers().stream().map(GamePlayer::getPlayerInfo).collect(toList()));
        return dto;
    }

    public Map<String, Object> getInfo(GamePlayer gp){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("created", getCreationDate());
        dto.put("gamePlayers", getGamePlayers().stream().map(GamePlayer::getPlayerInfo).collect(toList()));
        dto.put("ships", gp.getShips().stream().map(Ship::getInfo).collect(toList()));
        dto.put("salvoes", getGamePlayers().stream().map(GamePlayer::getSalvoesInfo).collect(toList()));
        return dto;
    }
}

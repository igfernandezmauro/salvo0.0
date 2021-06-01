package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class Salvo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int turn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    @ElementCollection
    @Column(name = "location")
    private List<String> locations = new ArrayList<>();

    public Salvo(){
    }

    public Salvo(int _turn, GamePlayer _gamePlayer, List<String> _locations){
        this.turn = _turn;
        _gamePlayer.addSalvo(this);
        this.locations = _locations;
    }

    public long getId(){
        return this.id;
    }

    public int getTurn(){
        return this.turn;
    }

    public void setTurn(int _turn){
        this.turn = _turn;
    }

    public GamePlayer getGamePlayer(){
        return this.gamePlayer;
    }

    public void setGamePlayer(GamePlayer _gamePlayer){
        this.gamePlayer = _gamePlayer;
    }

    public List<String> getLocations(){
        return this.locations;
    }

    public void addLocation(String _location){
        this.locations.add(_location);
    }

    public Map<String, Object> getInfo(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("turn", getTurn());
        dto.put("player", getGamePlayer().getPlayer().getId());
        dto.put("locations", getLocations());
        return dto;
    }
}

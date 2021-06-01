package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    Set<Ship> ships = new HashSet<>();

    public GamePlayer(){
    }

    public GamePlayer(Game _game, Player _player){
        this.game = _game;
        this.player = _player;
        this.joinDate = new Date();
    }

    public long getId() {
        return this.id;
    }

    public Date getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(Date _joinDate) {
        this.joinDate = _joinDate;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game _game) {
        this.game = _game;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player _player) {
        this.player = _player;
    }

    public Set<Ship> getShips(){
        return this.ships;
    }

    public void addShip(Ship _ship){
        _ship.setGamePlayer(this);
        this.ships.add(_ship);
    }

    public Map<String, Object> getPlayerInfo(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("player", getPlayer().getInfo());
        return dto;
    }

}

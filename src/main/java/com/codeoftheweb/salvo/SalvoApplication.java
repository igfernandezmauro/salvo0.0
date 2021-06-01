package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) { SpringApplication.run(SalvoApplication.class, args); }

	@Bean
	public CommandLineRunner initData(PlayerRepository pRepository, GameRepository gRepository,
									  GamePlayerRepository gpRepository, ShipRepository sRepository){
		return(args) -> {
			//Create Players
			Player player1 = new Player("j.bauer@ctu.gov");
			Player player2 = new Player("c.obrian@ctu.gov");
			Player player3 = new Player("t.almeida@ctu.gov");
			Player player4 = new Player("d.palmer@whitehouse.gov");

			//Create Games
			Date actualDate = new Date();
			Game game1 = new Game(actualDate);

			actualDate = Date.from(actualDate.toInstant().plusSeconds(3600));
			Game game2 = new Game(actualDate);

			actualDate = Date.from(actualDate.toInstant().plusSeconds(3600));
			Game game3 = new Game(actualDate);

			actualDate = Date.from(actualDate.toInstant().plusSeconds(3600));
			Game game4 = new Game(actualDate);

			actualDate = Date.from(actualDate.toInstant().plusSeconds(3600));
			Game game5 = new Game(actualDate);

			actualDate = Date.from(actualDate.toInstant().plusSeconds(3600));
			Game game6 = new Game(actualDate);

			//Join Players and Games
			GamePlayer gp1 = new GamePlayer(game1, player1);
			GamePlayer gp2 = new GamePlayer(game1, player2);
			GamePlayer gp3 = new GamePlayer(game2, player1);
			GamePlayer gp4 = new GamePlayer(game2, player2);
			GamePlayer gp5 = new GamePlayer(game3, player2);
			GamePlayer gp6 = new GamePlayer(game3, player3);
			GamePlayer gp7 = new GamePlayer(game4, player1);
			GamePlayer gp8 = new GamePlayer(game4, player2);
			GamePlayer gp9 = new GamePlayer(game5, player3);
			GamePlayer gp10 = new GamePlayer(game5, player1);
			GamePlayer gp11 = new GamePlayer(game6, player4);

			//Create Ships
			Ship s1 = new Ship("Destroyer", gp1, Arrays.asList("H2", "H3", "H4"));
			Ship s2 = new Ship("Submarine", gp1, Arrays.asList("E1", "F1", "G1"));
			Ship s3 = new Ship("Patrol Boat", gp1, Arrays.asList("B4", "B5"));
			Ship s4 = new Ship("Destroyer", gp2, Arrays.asList("B5", "C5", "D5"));
			Ship s5 = new Ship("Patrol Boat", gp2, Arrays.asList("F1", "F2"));
			Ship s6 = new Ship("Destroyer", gp3, Arrays.asList("B5", "C5", "D5"));
			Ship s7 = new Ship("Patrol Boat", gp3, Arrays.asList("C6", "C7"));
			Ship s8 = new Ship("Submarine", gp4, Arrays.asList("A2", "A3", "A4"));
			Ship s9 = new Ship("Patrol Boat", gp4, Arrays.asList("G6", "H6"));
			Ship s10 = new Ship("Destroyer", gp5, Arrays.asList("B5", "C5", "D5"));
			Ship s11 = new Ship("Patrol Boat", gp5, Arrays.asList("C6", "C7"));
			Ship s12 = new Ship("Submarine", gp6, Arrays.asList("A2", "A3", "A4"));
			Ship s13 = new Ship("Patrol Boat", gp6, Arrays.asList("G6", "H6"));
			Ship s14 = new Ship("Destroyer", gp8, Arrays.asList("B5", "C5", "D5"));
			Ship s15 = new Ship("Patrol Boat", gp8, Arrays.asList("C6", "C7"));
			Ship s16 = new Ship("Submarine", gp7, Arrays.asList("A2", "A3", "A4"));
			Ship s17 = new Ship("Patrol Boat", gp7, Arrays.asList("G6", "H6"));
			Ship s18 = new Ship("Destroyer", gp9, Arrays.asList("B5", "C5", "D5"));
			Ship s19 = new Ship("Patrol Boat", gp9, Arrays.asList("C6", "C7"));
			Ship s20 = new Ship("Submarine", gp10, Arrays.asList("A2", "A3", "A4"));
			Ship s21 = new Ship("Patrol Boat", gp10, Arrays.asList("G6", "H6"));
			Ship s22 = new Ship("Destroyer", gp11, Arrays.asList("B5", "C5", "D5"));
			Ship s23 = new Ship("Patrol Boat", gp11, Arrays.asList("C6", "C7"));

			//Save Players
			pRepository.save(player1);
			pRepository.save(player2);
			pRepository.save(player3);
			pRepository.save(player4);

			//Save Games
			gRepository.save(game1);
			gRepository.save(game2);
			gRepository.save(game3);
			gRepository.save(game4);
			gRepository.save(game5);
			gRepository.save(game6);

			//Save GamePlayers
			gpRepository.save(gp1);
			gpRepository.save(gp2);
			gpRepository.save(gp3);
			gpRepository.save(gp4);
			gpRepository.save(gp5);
			gpRepository.save(gp6);
			gpRepository.save(gp7);
			gpRepository.save(gp8);
			gpRepository.save(gp9);
			gpRepository.save(gp10);
			gpRepository.save(gp11);

			//Save Ships
			sRepository.save(s1);
			sRepository.save(s2);
			sRepository.save(s3);
			sRepository.save(s4);
			sRepository.save(s5);
			sRepository.save(s6);
			sRepository.save(s7);
			sRepository.save(s8);
			sRepository.save(s9);
			sRepository.save(s10);
			sRepository.save(s11);
			sRepository.save(s12);
			sRepository.save(s13);
			sRepository.save(s14);
			sRepository.save(s15);
			sRepository.save(s16);
			sRepository.save(s17);
			sRepository.save(s18);
			sRepository.save(s19);
			sRepository.save(s20);
			sRepository.save(s21);
			sRepository.save(s22);
			sRepository.save(s23);
		};
	}

}

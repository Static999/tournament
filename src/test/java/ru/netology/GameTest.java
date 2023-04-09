package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 20);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);
        int actual = game.round("Тата", "Катя");
        int excepted = 2;

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 30);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);
        int actual = game.round("Тата", "Катя");
        int excepted = 1;

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void testWhenPlayersDraw() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 25);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);
        int actual = game.round("Тата", "Катя");
        int excepted = 0;

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 20);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Федя", "Тата")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 20);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Катя", "Федя")
        );
    }

    @Test
    public void testWhenAllPlayersNotExist() {
        Game game = new Game();
        Player Tata = new Player(1, "Тата", 20);
        Player Katya = new Player(2, "Катя", 25);

        game.register(Tata);
        game.register(Katya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Сема", "Федя")
        );
    }
}







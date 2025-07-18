package dev.lpa.pirate;

import dev.lpa.game.Game;
import dev.lpa.game.GameAction;

import java.util.List;
import java.util.Map;

public class PirateGame extends Game<Pirate> {

    // there is first and second level data, second level -> list of town, first level list of list of town
    private static final List<List<String>> levelMap;

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        return Map.of();
    }
}

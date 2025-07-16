package dev.lpa.game;

import java.util.Map;

public class ShooterGame extends Game<Shooter>{


    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        return null;
    }
}

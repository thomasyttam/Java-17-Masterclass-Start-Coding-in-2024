package dev.lpa;

// Cannot inherit from final 'dev.lpa.game.GameAction', Record is final and cannot be extends
//class SpecialGameAction extends GameAction{
//
//    public SpecialGameAction(char key, String prompt, Predicate<Integer> action) {
//        super(key, prompt, action);
//    }
//}


// Cannot inherit from final enum 'dev.lpa.game.Weapon', Enum is final and cannot be extends
//class SpecialGameAction extends Weapon {}

import dev.lpa.game.GameConsole;
import dev.lpa.pirate.PirateGame;

//abstract class SpecialGameConsole<T extends Game<? extends Player>> // 'SpecialGameConsole' is abstract; cannot be instantiated
//class SpecialGameConsole<T extends Game<? extends Player>>
//        extends GameConsole<Game<? extends Player>> { // final keyword in GameConsole not allow to be inherited
//
////    private SpecialGameConsole(Game<? extends Player> game) { // cannot access by outside which no constructor can use
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}

public class MainFinal {

    public static void main(String[] args) {

        GameConsole<PirateGame> game =
                new GameConsole<>(new PirateGame("Pirate Game"));
    }
}

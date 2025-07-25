package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.pirate.PirateGame;

public class Main {

    public static void main(String[] args) {

//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

//        Weapon weapon = Weapon.getWeaponByChar('P');
//        System.out.println("weapon = "+ weapon + ", hitPoints=" +
//                weapon.getHitPoints() + ", minLevel=" + weapon.getMinLevel());
//
//        var list = Weapon.getWeaponsByLevel(1);
//        list.forEach(System.out::println);
//
//        Pirate tim = new Pirate("Tim");
//        System.out.println(tim);

//        PirateGame.getTowns(0).forEach(System.out::println);
//        System.out.println("-----------------------------------------------------");
//        PirateGame.getTowns(1).forEach(System.out::println);

//        PirateGame.getTowns(0).forEach(t ->System.out.println(t.information()));
//        System.out.println("-----------------------------------------------------");
//        PirateGame.getTowns(1).forEach(t ->System.out.println(t.information()));

//        Town bridgetown = new Town("Bridgetown", "Barbados", 0);
//        System.out.println(bridgetown);
//        System.out.println(bridgetown.information());

        // GameConsole constructor now protected
        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }
}

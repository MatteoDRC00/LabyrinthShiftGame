package entity;

import java.util.*;

public class Character {
    private String name;
    private String specialAbility;

    public Character(String name, String specialAbility) {
        this.name = name;
        this.specialAbility = specialAbility;
    }

    public String getName() {
        return name;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public static List<Character> generateCharacters() {
        return Arrays.asList(
                new Character("Guerriero", "Resistenza aumentata"),
                new Character("Mago", "Attacchi a distanza"),
                new Character("Ladro", "Velocità aumentata")
        );
    }
}

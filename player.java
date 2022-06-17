package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }
}

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

    public void addCard(Card card) {

        cards.add(card);
    }

//obtenemoszs las cartas del jugador

    public List<Card> getCards() {

        return cards;
    }

 // obtenemos el nombre del jugador
    //@return erl nombre del jugador
    public String getName() {

        return name;
    }

//restablece las cartas de todos los jugadores
    public void reset() {

        cards = new ArrayList<>();
    }

    @Override
    public String toString() {

        return String.format("%s: (%d cartas)", name, cards.size());
    }

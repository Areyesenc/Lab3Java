package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;


public class Dobble {
    private final List<Card> cards;

    public Dobble(int n) {
        cards = generateCards(n);
    }
   private static List<Card> generateCards(int numberOfCards) {
        List<Card> cards = new ArrayList<>();
        int n = getPrimeForKCards(numberOfCards);
        cards.add(new Card(IntStream.range(1, n + 2)
                .boxed()
                .map(Symbol::new)
                .collect(Collectors.toList())));
        for (int j = 1; j <= n; j++) {
            Card card = new Card();
            card.addSymbol(new Symbol(1));
            for (int k = 1; k <= n; k++) {
                card.addSymbol(new Symbol(n * j + (k + 1)));
            }
            cards.add(card);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Card card = new Card();
                card.addSymbol(new Symbol(i + 1));
                for (int k = 1; k <= n; k++) {
                    card.addSymbol(new Symbol(n + 2 + n * (k - 1) + (((i - 1) * (k - 1) + j - 1) % n)));
                }
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
        return cards.subList(0, numberOfCards);
    }

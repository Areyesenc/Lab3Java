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
    
        private static int getPrimeForKCards(int numberOfCards) {
        List<Integer> primes = getPrimseUpTo(numberOfCards);
        for (int prime : primes) {
            if (prime * prime + prime + 1 >= numberOfCards) return prime;
        }
        return primes.get(primes.size() - 1);
    }
    /**
     * Obtener números primos hasta n
     *
     * @param n el límite superior
     * @return una lista de números primos hasta n
     */
    private static List<Integer> getPrimseUpTo(int n) {
        return IntStream.range(2, n + 1)
                .boxed()
                .filter(Dobble::isPrime)
                .collect(Collectors.toList());
    }

    /**
     * Comprobar si un número dado es primo o no
     *
     * @param n el número para comprobar el numero primo
     * @return true si es primo... false en caso contrario
     */
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //obtiene la lista de cartas, retornando la lista de cartas del mazo.
    public List<Card> getCards() {

        return cards;
}

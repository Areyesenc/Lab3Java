package org.example;

import java.util.ArrayList;
import java.util.List;

public class Card {
    List<Symbol> symbols;
  
  //crea una nueva carta
      public Card() {
        
        symbols = new ArrayList<>();
    }
 // crea una carga con el simbolo obtenido mediante la lista
    public Card(List<Symbol> symbols) {
        
        this.symbols = symbols;
    }
 // agrega ubn simbolo a la carta
    public void addSymbol(Symbol symbol) {
        
        symbols.add(symbol);
    }
 //la carta obtiene el simbolo
    public List<Symbol> getSymbols() {
        
        return symbols;
    }
  
  //Faltaría el MATCH entre simbolos según los jugadores.
//AQUI TA EL MATCH :D
    
    public boolean hasSymbol(Symbol symbol) {
        return symbols.stream()
                .anyMatch(s -> s.equals(symbol));
    }

        @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Symbol symbol : symbols)
            stringBuilder.append(symbol)
                    .append(" ");
        return stringBuilder.toString()
                .strip();
    }

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DobbleGame {
    private final List<Player> players;
    int currentIndex;
    boolean gameOver;
    Scanner input;
    private Dobble dobble;

    // crea un nuevo juego de Dobble..
    public DobbleGame() {
        dobble = null;
        players = new ArrayList<>();
        currentIndex = 0;
        input = new Scanner(System.in);
    }
    /**
     * Añadir un jugador al juego
     *
     * @param player el jugador a añadir
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    //jugar un round
    public void playRound() {
        try {
            //muestra las dos cartas
            Card a = dobble.getCards()
                    .get(currentIndex);
            Card b = dobble.getCards()
                    .get(++currentIndex);
            System.out.println("Revelando cartas...");
            // Player player = null;
            System.out.println("jugador 1: " + a);
            System.out.println("Jugador 2: " + b);
            boolean correct = false;
            while (!correct) {
                //// introducir el nombre del jugador que ha introducido la respuesta correcta
                System.out.print("Nombre del jugador: ");
                String playerName = input.nextLine()
                        .strip();
        /*
                Player player = getPlayerByName(playerName);
                if (player != null) {
                    // agrega las cartas al jugador
                    player.addCard(a);
                    correct = true;
                } else {
                    System.out.printf("Jugador %s no existe.%n", playerName);
                }
            }


         */
                System.out.print("coloca la carta: ");
                int answer = Integer.parseInt(input.nextLine());
                correct = a.hasSymbol(new Symbol(answer)) && b.hasSymbol(new Symbol(answer));
                if (correct) {
                    Player player = getPlayerByName(playerName);
                    player.addCard(a);
                    System.out.printf("%s Ganaste!%n", player.getName());
                } else {
                    System.out.println("Respuesta erronea.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            //no mas cartas!
            gameOver = true;
            System.out.println("Game over!");
        }
            }
    /**
     * Jugar una partida de dobble
     */
    void play() {
        int option = -1;
        while (option != 5) {
            option = mainMenu();
            switch (option) {
                case 1:
                    createGameMenu();
                    break;
                case 2:
                    addPlayerMenu();
                    break;
                case 3:
                    playMenu();
                    break;
                case 4:
                    statsMenu();
                    break;
                case 5:
                    System.out.println("Gracias por jugar :).");
                    break;
                default:
                    System.out.println("Opcion erronea.");
            }
        }
    }

    /**
     * El menu principal
     *
     * @return de la opcion de meni seleccionado
     */
    int mainMenu() {
        try {
            System.out.println();
            System.out.println();
            System.out.println("Bienvenido al juego de Dobble!");
            System.out.println();
            System.out.println("1. Crear un juego");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Jugar!");
            System.out.println("4. Visualizar estado completo del juego");
            System.out.println("5. Salir");
            System.out.print("\t: ");
            return Integer.parseInt(input.nextLine());
        }catch (Exception ignored) {
            System.out.println("debes colocar una de las 5 opciones!!");
        }
        return 0;
    }

    //Creación del menu
    void createGameMenu() {
        try {
            System.out.print("Coloca el numero de cartas: ");
            int numberOfCards = Integer.parseInt(input.nextLine());
            dobble = new Dobble(numberOfCards);
            for (Player player : players) player.reset();
            currentIndex = 0;
            System.out.println("Juego creado.");
        } catch (Exception ignored) {
        }
    }

    //agrega un nuevo jugador al juego
    void addPlayerMenu() {
        System.out.print("Coloca el nombre del jugador: ");
        String name = input.nextLine()
                .strip();
        addPlayer(new Player(name));
    }

    //empieza el juego

    void playMenu() {
        if (players.size() < 2) {
            System.out.println("Por favor, agrega a lo menos 02 jugadores para jugar a Dobble.");
            return;
        }
        if (dobble == null) {
            System.out.println("Por favor crea un juego para jugar a Dobble");
            return;
        }
        while (!gameOver) {
            playRound();
        }
        System.out.println(this);
    }

    //muestra la estadistica
    void statsMenu() {

        System.out.println(this);
    }

    @Override
    public String toString() {
        if (dobble == null) return "No hay un juego en progreso.";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Estadistica actual:\n");
        for (Player player : players) {
            stringBuilder.append(player)
                    .append("\n");
        }
        stringBuilder.append("Status del juego: ")
                .append(gameOver ? String.format("Ganador: %s", getWinner().getName()) : "en progreso..")
                .append("\n");
        return stringBuilder.toString();
    }

    /**
     * Obtienr el ganador del juego.
     *
     * @return el ganador de la partida si el juego ha terminado, en caso contrario null
     */

    public Player getWinner() {
        if (!gameOver) return null;
        return players.stream()
                .reduce((player, player2) -> player2.getCards()
                        .size() > player.getCards()
                        .size() ? player2 : player)
                .orElse(null);
    }

    /**
     * Obtiene el jugador con el nombre dado.
     *
     * @param name el nombre del jugador
     * @return el jugador con el nombre dado, null si no existe.
     */
    private Player getPlayerByName(String name) {
        try {
            return players.stream()
                    .filter(player -> player.getName()
                            .equals(name))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception e) {
            return null;
        }
    }

  //  public static class GameOverException extends Exception {
  //  }

}

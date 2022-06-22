package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

//Main.java
//public static void main(String[] args) {

}

public class DobbleGame {
  
   public DobbleGame() {
        dobble = null; // jugadores. (play)
        players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option;
        boolean gameOver;    
        private Dobble dobble;

    public DobbleGame() {
        dobble = null;
        players = new ArrayList<>();
        currentIndex = 0;
        input = new Scanner(System.in);
    }

    public void addPlayer(Player player) 
       players.add(player);
    }
     
//playround para iniciar el juego.  
  
     
   public void playRound() {
      try {
        //muestra dos cartas
            Card a = dobble.getCards()
                    .get(currentIndex);
            Card b = dobble.getCards()
                    .get(++currentIndex);
            System.out.println("revelando las cartas..");
            System.out.println("Jugador1: " + a);
            System.out.println("jugador2: " + b);
            boolean correct = false;
            while (!correct) {
              // introducir el nombre del jugador que ha introducido la respuesta correcta
              System.out.print("nombre del jugador: ");
                String playerName = input.nextLine()
                        .strip();
                Player player = getPlayerByName(playerName);
                if (player != null) {
                    // añade la carta al jugador
                    player.addCard(a);
                    correct = true;
                } else {
                    System.out.printf("jugador %s no existe.%n", playerName);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        //no se lanzan mas cartas
            gameOver = true;
            System.out.println("Game over!");
        }
   }
/*  
Idea para agregar un jugador y quede en memoria... ojo con el override.
   public void addPlayer(Player player) {
        players.add(player);
    }
*/
     
  //para clase "play" usa idea "switch - case(del 1 al 4) - defatul (por si menu no existe) ...
  
  //idea del menu como sería...
  int Menu(){
        System.out.println();
        System.out.println();
        System.out.println("Bienvenido al juego de Dobble!");
        System.out.println();
        System.out.println("1. Crear un juego");
        System.out.println("2. Registrar jugador");
        System.out.println("3. Jugar!");
        System.out.println("4. Visualizar estado completo del juego");
        system.out.println("5. Salir");
        //syso ("INTRODUZCA SU OPCION" + algo);
        System.out.print("\t: ");
        return Integer.parseInt(input.nextLine());
  }
  
// 

        while (option != 5) {
            option = Menu();
            switch (option) {
                case 1:
                    createGame();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    play();
                    break;
                case 4:
                    status();
                    break;
                case 5:
                    System.out.println("Gracias!");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        }
    }

  //facil - constructor1
void createGame(){
  try{
    system.out.print("coloca el numero de cartas: ");
    int numbercards = integer.parseInt(input.nextLine());
    dobble = new Dobble(numbercards);
    sysetm.out.println("juego creado");
    
  }catch(exception ignored){
    system.out.println("Input invalido");
  }
}
  //facil .. --addP(new player(name))--  2 jugadores como mínimo .. 
void register(){
    System.out.print("Nombre del jugador: ");
    String name = input.nextLine()
    addPlayer(new Player(name)); //clase player
}
  
  //(ver la hoja)

//empieza el juego
void playMenu(){
    if (players.size() < 2){
    System.out.println("debes añadir al menos dos jugadores");
    return;
  }
  if (dobble == null) { //esto indica que si no se ha creado un juego, regresa al menu para crearlo!
    System.out.println("crea un juego");
    return;
    
   while (!gameOver) {
     playRound();
   }
   System.out.println(this);
      
  //si esta correcto todo, entonces aquí ya se podría jugar y ver status.. 
}
  
                       
//quien gana y quien pierde... debería ir dentro del metodo toString() cómo representación del estado del juego (?)
void status(){
    System.out.println(this);
    }
}

    @Override
    public String toString() {
        if (dobble == null) return "No hay un juego en progreso!";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("estadistica dsewl juego:\n");
        for (Player player : players) {
            stringBuilder.append(player)
                    .append("\n");
        }
        stringBuilder.append("estatus del juego: ")
                .append(gameOver ? String.format("Gano el jugador %s", getWinner().getName()) : "en progreso..")
                .append("\n");
        return stringBuilder.toString();
    }

    public Player getWinner() {
        if (!gameOver) return null;
        return players.stream()
                .reduce((player, player2) -> player2.getCards()
                        .size() > player.getCards()
                        .size() ? player2 : player)
                .orElse(null);
    }

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

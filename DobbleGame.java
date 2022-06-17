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
        
//playround para iniciar el juego.  
  
   public void playRound() {
     
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
    
  }catch(exception){
  }
}
  //facil .. --addP(new player(name))--  2 jugadores como mínimo .. 
void register(){
    System.out.print("Nombre del jugador: ");
    String name = input.nextLine()
  //  addPlayer(new Player(name)); //clase player
}
  
  //(ver la hoja)
void playMenu(){
    if (players.size() < 2){
    System.out.println("debes añadir al menos dos jugadores"
    return;
  }
  if (dobble == null) { //esto indica que si no se ha creado un juego, regresa al menu para crearlo!
    System.out.println("crea un juego");
    return;
    
  //si esta correcto todo, entonces aquí ya se podría jugar y ver status.. 
}
  
                       
//quien gana y quien pierde... debería ir dentro del metodo toString() cómo representación del estado del juego (?)
void status(){
    
}

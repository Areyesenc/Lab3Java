import java.util.ArrayList;
import java.util.Scanner;


public class DobbleGame {
  
   public DobbleGame() {
        dobble = null;
        players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
    }
  
//playround para iniciar el juego.  
  
   public void playRound() {
     
   }
  
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
        //syso ("INTRODUZCA SU OPCION" + algo);
  }
  

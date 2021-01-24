/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import java.util.Scanner;
import munoz.jorquera.diego.DungeonTower.Model.Habitacio;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioBuida;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioMonstre;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioPocio;
import munoz.jorquera.diego.DungeonTower.Model.Jugador;

/**
 *
 * @author diego
 */
public class Joc {
  private final Scanner in = new Scanner(System.in);
  
  private Jugador jugador;
  private final boolean DEBUG = false;
  private final int SCREEN_HEIGHT = 30;
  
  public Joc (Jugador jugador){
    this.jugador = jugador;
  }
  
  public void jugar(Mapa mapa, boolean interactiu){
    
    Habitacio current;
    
    if(interactiu){
      System.out.println(Visual.initWindow(SCREEN_HEIGHT));
      in.nextLine();
      Visual.intro(SCREEN_HEIGHT, 500, 5000);
    }
    
    do{
      current = mapa.getHabitacioActual();
      
      if(interactiu)
        System.out.println(Visual.clear(SCREEN_HEIGHT));
  
      System.out.println(mapa.toString());
      
      //Room Logic
      System.out.println(current.activar(jugador));
      
      if(DEBUG){
        System.out.println("Stats:\nVida: " + jugador.getVidaTotal() + "\nAtac: " + jugador.getAtacTotal() 
        + "\nDefensa: " + jugador.getDefensaTotal());
      }
      
      if(interactiu){
        System.out.println("Prem [Enter] per entrar a la següent habitació.");
        in.nextLine();
        System.out.println(Visual.clear(SCREEN_HEIGHT));
        Visual.fade(SCREEN_HEIGHT, 300, 300*6);
      }
      
    }while(mapa.mou() && jugador.isAlive());
    
    if(interactiu)
      System.out.println(Visual.clear(SCREEN_HEIGHT));
    
    if(!jugador.isAlive()){
      System.out.println("HAS MORT!! El teu esperit vagarà per la torre eternament...");
    } else {
      System.out.println("ENHORABONA!! has sortit de la TORRE");
    }
    
    if(interactiu)
      Visual.center(SCREEN_HEIGHT, 1);
    
  }
}

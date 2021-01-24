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
  private final boolean DEBUG = true;
  
  public Joc (Jugador jugador){
    this.jugador = jugador;
  }
  
  public void jugar(Mapa mapa, boolean interactiu){
    
    Habitacio current;
    
    System.out.println(Visual.initWindow(14));
    if(interactiu)
      in.nextLine();
    
    do{
      current = mapa.getHabitacioActual();
      
      System.out.println(Visual.clear(7));
      System.out.println(mapa.toString());
      
      //Room Logic
      if( current instanceof HabitacioBuida){
         //-----
      } else if(current instanceof HabitacioMonstre){
        //TODO battle
      } else if(current instanceof HabitacioPocio){
        System.out.println(current.activar(jugador));
      }
      
      if(DEBUG){
        System.out.println("Stats:\nVida: " + jugador.getVidaTotal() + "\nAtac: " + jugador.getAtacTotal() 
        + "\nDefensa: " + jugador.getDefensaTotal());
      }
      
      if(interactiu)
        in.nextLine();
    }while(mapa.mou());
  }
}

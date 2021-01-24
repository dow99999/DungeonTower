/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import java.util.Scanner;
import munoz.jorquera.diego.DungeonTower.Model.Jugador;

/**
 *
 * @author diego
 */
public class Joc {
  private final Scanner in = new Scanner(System.in);
  
  private Jugador jugador;
  private Mapa mapa;
  private boolean interactiu;
  
  public Joc (Jugador jugador){
    this.jugador = jugador;
  }
  
  public void jugar(Mapa mapa, boolean interactiu){
    
    System.out.println(Visual.initWindow(14));
    in.nextLine();
    
    do{
      System.out.println(Visual.clear(7));
      System.out.println(mapa.toString());
      in.nextLine();
    }while(mapa.mou());
  }
}

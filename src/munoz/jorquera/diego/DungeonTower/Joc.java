/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import munoz.jorquera.diego.DungeonTower.Model.Jugador;

/**
 *
 * @author diego
 */
public class Joc {
  private Jugador jugador;
  private Mapa mapa;
  private boolean interactiu;
  
  public Joc (Jugador jugador){
    this.jugador = jugador;
  }
  
  public void jugar(Mapa mapa, boolean interactiu){
    System.out.println(mapa.toString());
  }
}

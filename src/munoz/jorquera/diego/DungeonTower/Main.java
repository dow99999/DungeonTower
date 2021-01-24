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
public class Main {
  
  public static void main(String[] args) {
    Joc j = new Joc(new Jugador());
    
    j.jugar(GeneradorMapes.crearMapa("PA1PA1..."), true);
    
    
  }
}

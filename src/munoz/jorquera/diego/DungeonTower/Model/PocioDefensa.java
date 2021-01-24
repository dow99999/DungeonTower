/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower.Model;

/**
 *
 * @author diego
 */
public class PocioDefensa extends Pocio {
    
  public PocioDefensa(String nom, int intensitat) {
    super(nom, intensitat);
  }

  @Override
  public String efecte(Jugador jugador) {
    return null;
  }
  
}

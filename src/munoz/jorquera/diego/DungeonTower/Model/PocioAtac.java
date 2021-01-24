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
public class PocioAtac extends Pocio{
  
  public PocioAtac(String nom, int intensitat) {
    super(nom, intensitat);
  }

  @Override
  public String efecte(Jugador jugador) {
    jugador.modAtc(intensitat);
    return "L'atac del jugador ha incrementat en " + intensitat;
  }
  
}

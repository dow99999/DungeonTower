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
public class Jugador extends Personatge{
  public final int VIDA_MAX = 10; //siempre sera 10
  
  public Jugador(){
    super();
    
    vida = VIDA_MAX;
    atac = 1;
    defensa = 1;
  }
  
}

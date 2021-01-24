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
public abstract class Habitacio {
  public static final int HEIGHT = 5;
  protected boolean activa;
  
  public abstract String activar(Jugador jugador);
  public abstract String entrar();
  public abstract String toString(int linia);
  
  public String sortir(){
    activa = false;
    return null;
  }
  
}

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
  
  /**
   * Funcion usada para activar la habitacion y que esta gestione lo necesario
   * @param jugador el jugador
   * @return Un mensaje de la habitacion
   */
  public abstract String activar(Jugador jugador);
  
  /**
   * Funcion usada para saber que el jugador ha salido de la habitacion
   * @return null -(-Un mensaje de entrada a la habitacion-)- no se ha usado
   */
  public abstract String entrar();
  
  /**
   * Funcion que devuelve la imagen de la habitacion de forma que se pueda imprimir horizontalmente
   * @param linia la linea de habitacion que se quiere imprimir
   * @return el String con la linea de habitacion que se quiere imprimir
   */
  public abstract String toString(int linia);
  
  /**
   * Funcion usada para saber que el jugador ha salido de la habitacion
   * @return null -(-mensaje opcional de salida de la habitacion-)- no se ha usado
   */
  public String sortir(){
    activa = false;
    return null;
  }
  
}

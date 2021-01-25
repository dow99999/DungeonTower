/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import munoz.jorquera.diego.DungeonTower.Model.Habitacio;

/**
 *
 * @author diego
 */
public class Mapa {

  private Habitacio[] habitacions;
  private int currenth;
  

  Mapa(Habitacio[] habitacions) {
    this.habitacions = habitacions;
    currenth = 0;
    this.habitacions[0].entrar();
  }

  public Habitacio getHabitacioActual() {
    return habitacions[currenth];
  }

  /**
   * Funcion que intenta mover al usuario de la habitacion en la que se encuentra a la siguiente
   * @return true si ha podido moverse | false si ya no puede continuar
   */
  public boolean mou() {
    boolean canMove = (currenth < habitacions.length - 1);
    
    if(canMove){
      habitacions[currenth].sortir();
      currenth++;
      habitacions[currenth].entrar();
    }
    
    return canMove;
  }

  /**
   * Funcion para ver las habitaciones del mapa una al lado de la otra
   * @return 
   */
  @Override
  public String toString() {
    String out = "";
    
    for (int j = 0; j < Habitacio.HEIGHT; j++) {
      for (int i = 0; i < habitacions.length; i++) {
        out += habitacions[i].toString(j) + ((i < habitacions.length-1) ? (j == 2 ? " -> " : "    ") : "");
      }
      out += "\n";
    }

    return out;
  }
}

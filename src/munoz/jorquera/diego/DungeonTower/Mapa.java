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

  public boolean mou() {
    boolean canMove = (currenth < habitacions.length - 1);
    
    if(canMove){
      habitacions[currenth].sortir();
      currenth++;
      habitacions[currenth].entrar();
    }
    
    return canMove;
  }

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

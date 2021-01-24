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

  Mapa(Habitacio[] habitacions) {
    this.habitacions = habitacions;
  }

  public Habitacio getHabitacioActual() {
    return null;
  }

  public boolean mou() {
    return true;
  }

  @Override
  public String toString() {
    String out = "";

    for (int j = 0; j < Habitacio.HEIGHT; j++) {
      for (int i = 0; i < habitacions.length; i++) {
        out += habitacions[i].toString(j) + (j == 2 && i < habitacions.length-1 ? " -> " : "    ");
      }
      out += "\n";
    }

    return out;
  }
}

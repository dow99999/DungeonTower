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
public class HabitacioBuida extends Habitacio{

  @Override
  public String activar(Jugador jugador) {
    return "Entres a l'habitacio. No hi ha res, esta buida.";
  }

  @Override
  public String entrar() {
    activa = true;
    return null;
  }

  @Override
  public String toString(int linia) {
    String out = "";
    
    switch(linia){
      case 0:
      case 4:
        out = "+-----+";
        break;
      case 1:
      case 3:
        out = "|     |";
        break;
      case 2:
        out = activa ? "|  J  |" : "|     |";
        break;
    }
    
    return out;
  }
  
}

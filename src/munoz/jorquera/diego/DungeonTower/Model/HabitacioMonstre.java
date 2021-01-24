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
public class HabitacioMonstre extends Habitacio{

  private Monstre monstre;
  
  public HabitacioMonstre(Monstre monstre){
    this.monstre = monstre;
  }
  
  @Override
  public String activar(Jugador jugador) {
    return null;
  }

  @Override
  public String entrar() {
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
        out = "+  M  +";
        break;
      case 2:
        out = activa ? "+  J  +" : "+     +";
        break;
      case 3:
        out = "+     +";
    }
    
    return out;
  }
  
}

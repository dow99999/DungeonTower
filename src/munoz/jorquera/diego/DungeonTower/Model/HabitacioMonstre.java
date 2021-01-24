/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower.Model;

import munoz.jorquera.diego.DungeonTower.Visual;

/**
 *
 * @author diego
 */
public class HabitacioMonstre extends Habitacio{

  private Monstre monstre;
  
  public HabitacioMonstre(Monstre monstre){
    this.monstre = monstre;
  }
  
  private void hit(Personatge a, Personatge b){
    int dmg = a.getAtacTotal() - b.getDefensaTotal();
    b.modVida(dmg < 0 ? 0 : -dmg);
  }
  
  @Override
  public String activar(Jugador jugador) {
    String out = "";
    int i = 1;
    
    out += battleLog("--Inici del combat--\n", jugador, monstre);
    
    while(jugador.isAlive() && monstre.isAlive() && i <= 3){
      hit(jugador, monstre);
      hit(monstre, jugador);
      out += battleLog("--Assalt " + i + ":--\n", jugador, monstre);
      i++;
    }
    
    if(!jugador.isAlive()){
      out += "T'ha matat un " + monstre.getNom();
    } else if(!monstre.isAlive()){
      out += "Enhorabona, has matat un " + monstre.getNom();
    } else{
      out += "Enhorabona, has matat un " + monstre.getNom() + " per esgotament"; //TODO sistema para medir la resistencia entre dos personajes (?)
    }
    
    return out;
  }
  
  private String battleLog(String i, Jugador jugador, Monstre monstre){
    String out = "";
    out += i;
      out += "Jugador " + Visual.HealthBar(jugador.getVidaTotal(), jugador.vidaMax) + "\n";
      out += monstre.getNom() + Visual.HealthBar(monstre.getVidaTotal(), monstre.getVida()) + "\n";
      out += "---------------------\n\n";
    return out;
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
        out = monstre.isAlive() ? "+  M  +" : "+  X  +";
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

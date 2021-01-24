/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import munoz.jorquera.diego.DungeonTower.Model.Monstre;
import munoz.jorquera.diego.DungeonTower.Model.TipusMonstre;

/**
 *
 * @author diego
 */
public class GeneradorMonstres extends Monstre{
  public GeneradorMonstres(){
    super();
  }
  
  private static void initStats(Monstre aux, TipusMonstre tipus){
    switch(tipus){
      case Ashscream:
        aux.setVidaBase(1);
        aux.setAtacBase(1);
        aux.setDefensaBase(0);
        break;
      case Bladetree:
        aux.setVidaBase(2);
        aux.setAtacBase(3);
        aux.setDefensaBase(0);
        break;
      case Cryptvine:
        aux.setVidaBase(3);
        aux.setAtacBase(1);
        aux.setDefensaBase(1);
        break;
    }
  }
  
  public static Monstre crearMonstre(String nom){
    Monstre aux = new GeneradorMonstres();
    aux.setNom(nom);
    initStats(aux, TipusMonstre.valueOf(nom));
    return aux;
  }
  
  public static Monstre crearMonstre(TipusMonstre tipus){
    Monstre aux = new GeneradorMonstres();
    aux.setNom(tipus);
    initStats(aux, tipus);
    return aux;
  }
}

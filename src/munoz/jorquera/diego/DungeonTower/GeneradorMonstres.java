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
  
  public static Monstre crearMonstre(String nom){
    Monstre aux = new GeneradorMonstres();
    aux.setNom(nom);
    return aux;
  }
  
  public static Monstre crearMonstre(TipusMonstre tipus){
    Monstre aux = new GeneradorMonstres();
    aux.setNom(tipus);
    return aux;
  }
}

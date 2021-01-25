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
public abstract class Pocio {
  protected int intensitat;
  private String nom;
  
  protected Pocio(String nom, int intensitat){
    this.nom = nom;
    this.intensitat = intensitat;
  }
  
  /**
   * Funcion que aplica los efectos de una pocion a un jugador
   * @param jugador el jugador
   * @return mensaje explicativo con los efectos de la pocion sobre el jugador
   */
  public abstract String efecte(Jugador jugador);
  
  public String getNom(){
    return nom;
  }
  
}

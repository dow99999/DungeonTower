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
public class Monstre extends Personatge{
  private String nom;
  
  protected Monstre(){
    super();
  }
  
  public void setVidaBase(int vida){
    this.vida = vida;
  }
  
  public void setAtacBase(int atac){
    this.atac = atac;
  }
  
  public void setDefensaBase(int defensa){
    this.defensa = defensa;
  }
  
  public TipusMonstre getNom(){
    return TipusMonstre.valueOf(nom);
  }
  
  public void setNom(String nom){
    this.nom = nom;
  }
  
  public void setNom(TipusMonstre nom){
    this.nom = nom.toString();
  }
}

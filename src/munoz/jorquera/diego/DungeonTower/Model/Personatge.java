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
public abstract class Personatge {
  protected int vida;
  protected int atac;
  protected int defensa;
  protected int vidaextra;
  protected int atacextra;
  protected int defensaextra;
  protected boolean esticViu;

  protected Personatge(){
    vida = 1;
    atac = 0;
    defensa = 0;
    vidaextra = 0;
    atacextra = 0;
    defensaextra = 0;
    esticViu = true;
  }
  
  public int getVida() {
    return vida;
  }

  public int getAtac() {
    return atac;
  }

  public int getDefensa() {
    return defensa;
  }

  public int getVidaextra() {
    return vidaextra;
  }

  public int getAtacextra() {
    return atacextra;
  }

  public int getDefensaextra() {
    return defensaextra;
  }
  
  public int getVidaTotal() {
    int out = vida + vidaextra;
    return out < 0 ? 0 : out;
  }

  public int getAtacTotal() {
    return atac + atacextra;
  }

  public int getDefensaTotal() {
    return defensa + defensaextra;
  }
  
  public void modVida(int mod){
    this.vidaextra += mod;
    esticViu = getVidaTotal() > 0;
  }
  
  public void modAtc(int mod){
    this.atacextra += mod;
  }
  
  public void modDef(int mod){
    this.defensaextra += mod;
  }

  public boolean isAlive() {
    return esticViu;
  }  
}

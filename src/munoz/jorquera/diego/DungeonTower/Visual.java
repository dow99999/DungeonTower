/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

/**
 *
 * @author diego
 */
public class Visual {
  public static String clear(int lines){
    String out = "";
    for(int i = 0; i < lines; i++){
      out += "\n";
    }
    return out;
  }
  
  public static String initWindow(int lines){
    String out = "---------------------------------------";
    
    for(int i = 2; i < lines; i++){
      out += "\n";
    }
    
    out += "Cambia el tamano de la ventana hasta que las lineas de arriba esten en el limite superior de la pantalla y este mensaje en el inferior. presiona enter para continuar";
    
    return out;
  }
}

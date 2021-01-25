/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import munoz.jorquera.diego.DungeonTower.Model.Habitacio;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioBuida;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioMonstre;
import munoz.jorquera.diego.DungeonTower.Model.HabitacioPocio;
import munoz.jorquera.diego.DungeonTower.Model.PocioAtac;
import munoz.jorquera.diego.DungeonTower.Model.PocioDefensa;
import munoz.jorquera.diego.DungeonTower.Model.TipusMonstre;

/**
 *
 * @author diego
 */
public class GeneradorMapes {
  
  /**
   * Funcion que genera un objeto de tipo mapa a partir de un String con el tipo de habitaciones que se quieren
   * @param habitacionsNivell String desde el que se construira el array de habitaciones
   * @return Mapa un mapa con las habitaciones entradas
   */
  public static Mapa crearMapa(String habitacionsNivell){
    Habitacio[] habitacions = null;
    
    if(habitacionsNivell.length() % 3 == 0){
      habitacions = new Habitacio[habitacionsNivell.length()/3];
      for(int i = 0; i < habitacionsNivell.length(); i+=3){
        switch(habitacionsNivell.charAt(i)){
          
          //HabitacioPocio
          case 'P':
            switch(habitacionsNivell.charAt(i+1)){
              case 'A':
                habitacions[i/3] = new HabitacioPocio(new PocioAtac("A", Utils.valueOfChar(habitacionsNivell.charAt(i+2))));
              break;
              case 'D':
                habitacions[i/3] = new HabitacioPocio(new PocioDefensa("D", Utils.valueOfChar(habitacionsNivell.charAt(i+2))));
              break;
            }
            break;
          
          //HabitacioMonstre
          case 'M':
            switch(habitacionsNivell.charAt(i+1)){
              case 'A':
                habitacions[i/3] = new HabitacioMonstre(GeneradorMonstres.crearMonstre(TipusMonstre.Ashscream));
                break;
              case 'B':
                habitacions[i/3] = new HabitacioMonstre(GeneradorMonstres.crearMonstre(TipusMonstre.Bladetree));
                break;
              case 'C':
                habitacions[i/3] = new HabitacioMonstre(GeneradorMonstres.crearMonstre(TipusMonstre.Cryptvine));
                break;
            }
            break;
            
          //HabitacioBuida
          case '.':
            habitacions[i/3] = new HabitacioBuida();
            break;
            
        }
      }
    }
    
    
    return habitacions == null ? null : new Mapa(habitacions);
  }
}

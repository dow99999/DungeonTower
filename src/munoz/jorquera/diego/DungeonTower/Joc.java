/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import java.util.Scanner;
import munoz.jorquera.diego.DungeonTower.Model.Habitacio;
import munoz.jorquera.diego.DungeonTower.Model.Jugador;

/**
 *
 * @author diego
 */
public class Joc {
  private final Scanner in = new Scanner(System.in);
  
  private Jugador jugador;
  private final int SCREEN_HEIGHT = 30;
  
  public Joc (Jugador jugador){
    this.jugador = jugador;
  }
  
  /**
   * Procedimiento principal en el que se encuentra el bucle del juego
   * @param mapa Mapa con el que se jugara
   * @param interactiu true -> hay animaciones y se debe pulsar el enter para continuar | false -> no hay animaciones y se ejecuta todo sin necesidad del input del usuario
   */
  public void jugar(Mapa mapa, boolean interactiu){
    
    Habitacio current;
    int off = 0;
    
    if(interactiu){
      System.out.println(Visual.initWindow(SCREEN_HEIGHT));     //Pedimos al usuario que redimensione la ventana poder ver el juego de forma optima
      in.nextLine();
      Visual.intro(SCREEN_HEIGHT, 500, 5000);                   //Mostramos una animacion inicial con el titulo del juego
    }
    
    do{
      current = mapa.getHabitacioActual();                      //guardamos la habitacion actual para su posterior uso
      
      if(interactiu)
        System.out.println(Visual.clear(SCREEN_HEIGHT));        //limpiamos la pantalla
  
      System.out.println(mapa.toString());                      //mostramos las habitaciones
      
      System.out.println(current.activar(jugador));             //procesamos la accion de la habitacion
      
      if(interactiu && jugador.isAlive()){                      //si no estamos vivos no pedimos input de usuario ni hacemos animacion entre habitacion
        System.out.println("Prem [Enter] per entrar a la següent habitació.");
        in.nextLine();
        System.out.println(Visual.clear(SCREEN_HEIGHT));        //limpiamos la pantalla
        Visual.fade(SCREEN_HEIGHT, 300, 300*6);                 //animacion entre habitaciones
      }
      
    }while(mapa.mou() && jugador.isAlive());                    //nos movemos de habitacion y comprobamos si podemos movernos ademas de si estamos vivos
    
    
    if(interactiu && jugador.isAlive())                         //si morimos no limpiamos la pantalla para ver el ultimo combate
      System.out.println(Visual.clear(SCREEN_HEIGHT));
    
    
    if(!jugador.isAlive()){                                 //Caso perder (primero se comprueba este caso para que no ganemos estando muertos)
      try{
        Thread.sleep(5000);                                     //esperamos a que el usuario lea la ultima batalla y mostramos el mensaje final
      } catch(InterruptedException e) {}
      
      System.out.println("HAS MORT!! El teu esperit vagarà per la torre eternament...");
      off = Visual.skull() / 2;                                 //se guarda la longitud del ASCIIart      

    } else {                                                //Caso ganar
      System.out.println("ENHORABONA!! has sortit de la TORRE");
      off = Visual.tower() / 2;                                 //se guarda la longitud del ASCIIart
    }
    
    if(interactiu)
        Visual.center(SCREEN_HEIGHT, off + 2);      //se muestra la imagen final y se intenta centrar (+2 por el build successful de netbeans, en consola no seria necesario)
    
  }
}

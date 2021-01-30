/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Visual {

  /**
   * Funcion usada para limpiar la pantalla
   * @param lines el numero de lineas que se quieren limpiar
   * @return String que al imprimir limpiara la pantalla
   */
  public static String clear(int lines) {
    String out = "";
    for (int i = 0; i < lines; i++) {
      out += "\n";
    }
    return out;
  }

  /**
   * Funcion usada para pedir al usuario que redimensione la consola y asi poder ver el juego de manera optima
   * @param lines las lineas maximas que se veran por pantalla
   * @return un String que al imprimir mostrara la guia al usuario
   */
  public static String initWindow(int lines) {
    String out = "---------------------------------------";

    for (int i = 2; i < lines; i++) {
      out += "\n";
    }

    out += "Cambia el tamano de la ventana hasta que las lineas de arriba esten en el limite superior de la pantalla y este mensaje en el inferior. Presiona enter para continuar";

    return out;
  }

  /**
   * Funcion para generar una barra de vida a partir de la vida maxima y la actual
   * @param current la vida actual
   * @param max la vida maxima
   * @return un String con la barra de vida formada
   */
  public static String HealthBar(int current, int max) {
    String out = "[";

    for (int i = 0; i < max; i++) {
      out += (i < current) ? "•" : " ";
    }

    out += "]";

    return out;
  }

  /**
   * Procedimiento que muestra por pantalla una animacion que oscila, similar a la luz de una vela
   * @param lines las lineas maximas de la pantalla
   * @param wait el tiempo entre fotogramas
   * @param span el tiempo maximo de la animacion
   */
  public static void fade(int lines, int wait, int span) {
    char[][][] screen = new char[][][]{
      {
        {'░', '░', '▒', '▒', '▒', '░', '░'},
        {'░', '▒', '▒', '▓', '▒', '▒', '░'},
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'},
        {'▒', '▓', '▓', '▓', '▓', '▓', '▒'},
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'},
        {'░', '▒', '▒', '▓', '▒', '▒', '░'},
        {'░', '░', '▒', '▒', '▒', '░', '░'}
      },
      {
        {'░', '▒', '▒', '▓', '▒', '▒', '░'},
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'},
        {'▒', '▓', '▓', '▓', '▓', '▓', '▒'},
        {'▓', '▓', '▓', '▒', '▓', '▓', '▓'},
        {'▒', '▓', '▓', '▓', '▓', '▓', '▒'},
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'},
        {'░', '▒', '▒', '▓', '▒', '▒', '░'}
      },
      {
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'},
        {'▒', '▓', '▓', '▓', '▓', '▓', '▒'},
        {'▓', '▓', '▓', '▒', '▓', '▓', '▓'},
        {'▓', '▓', '▒', '░', '▒', '▓', '▓'},
        {'▓', '▓', '▓', '▒', '▓', '▓', '▓'},
        {'▒', '▓', '▓', '▓', '▓', '▓', '▒'},
        {'▒', '▒', '▓', '▓', '▓', '▒', '▒'}
      },};

    int times = span / wait;
    boolean dir = true;
    int frame = 0;

    for (int x = 0; x < times; x++) {
      System.out.println(clear(lines));

      frame += dir ? 1 : -1; //cambiamos de frame dependiendo de la direccion
      System.out.print("Canviant d'habitacio");
      for (int i = 0; i < frame; i++) {
        System.out.print("."); //el texto tambien oscila como la animacion (solo los puntos suspensivos)
      }
      System.out.println();
      for (int i = 0; i < screen[0].length; i++) {
        for (int j = 0; j < screen[0][0].length; j++) {
          System.out.print(screen[frame][i][j]);
        }
        System.out.println();
      }

      center(lines, 3); //centramos la animacion en la pantalla

      if (frame == 2 || frame == 0) {
        dir = !dir; //cambiamos la direccion al llegar a algun extremo
      }

      try {
        Thread.sleep(wait); //espera entre fotogramas
      } catch (InterruptedException ex) {
        Logger.getLogger(Visual.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }

  /**
   * Procedimiento que muestra por pantalla una animacion con el logo del juego
   * @param lines las lineas maximas de la pantalla
   * @param wait el tiempo de espera entre fotogramas
   * @param span el tiempo total de la animacion
   */
  public static void intro(int lines, int wait, int span) {

    boolean horizontal = false;

    
    /*
      ____                             _____
     |    \ _ _ ___ ___ ___ ___ ___   |_   _|___ _ _ _ ___ ___
     |  |  | | |   | . | -_| . |   |    | | | . | | | | -_|  _|
     |____/|___|_|_|_  |___|___|_|_|    |_| |___|_____|___|_|
                   |___|
    */
    char[][] title = new char[][]{
      {' ', '_', '_', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', '_', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {'|', ' ', ' ', ' ', ' ', '\\', ' ', '_', ' ', '_', ' ', '_', '_', '_', ' ', '_', '_', '_', ' ', '_', '_', '_', ' ', '_', '_', '_', ' ', '_', '_', '_', ' ', ' ', ' ', '|', '_', ' ', ' ', ' ', '_', '|', '_', '_', '_', ' ', '_', ' ', '_', ' ', '_', ' ', '_', '_', '_', ' ', '_', '_', '_', ' '},
      {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', '|', ' ', '|', ' ', ' ', ' ', '|', ' ', '.', ' ', '|', ' ', '-', '_', '|', ' ', '.', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' ', '|', ' ', '|', ' ', '.', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '-', '_', '|', ' ', ' ', '_', '|'},
      {'|', '_', '_', '_', '_', '/', '|', '_', '_', '_', '|', '_', '|', '_', '|', '_', ' ', ' ', '|', '_', '_', '_', '|', '_', '_', '_', '|', '_', '|', '_', '|', ' ', ' ', ' ', ' ', '|', '_', '|', ' ', '|', '_', '_', '_', '|', '_', '_', '_', '_', '_', '|', '_', '_', '_', '|', '_', '|', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '_', '_', '_', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    int times = span / wait;

    for (int x = 0; x < times; x++) {
      System.out.println(clear(lines));
      if (x % 5 == 0) {
        horizontal = !horizontal;
      }
      for (int i = 0; i < title.length; i++) {
        for (int j = 0; j < title[0].length; j++) {
          if (horizontal) {                                               //sumamos a la altura del titulo un valor externo y al hacer el
            System.out.print(title[(i + x) % title.length][j]);           //modulo del resultado obtenemos una sensacion de rotacion en el eje horizontal
          } else {                                                        
            System.out.print(title[i][(j + (x * 7)) % title[0].length]);  //lo mismo de arriba pero el el eje vertical, en este caso ademas se 
          }                                                                //anade un multiplicador para que vaya mas rapido
        }
        System.out.println();
      }

      center(lines, 3);

      try {
        Thread.sleep(wait);
      } catch (InterruptedException ex) {
      }
    }

  }

  /**
   * Funcion que imprime por pantalla la imagen de una torre
   * @return la longitud vertical de la torre
   */
  public static int tower() {
    char[][] tower = new char[][]{
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '>', '>', '>', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', ' ', ' ', '_', '|', '_', ' ', ' ', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ';', '|', '_', '|', ';', '|', '_', '|', ';', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', '\\', '.', ' ', ' ', ' ', ' ', '.', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', '\\', ':', ' ', ' ', '.', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', '.', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', ' ', '.', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\\', ',', '/', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', ',', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', '`', '\\'},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', 'W', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '|', ':', ' ', '.', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', '_', '.', ' ', ' ', ' ', '|', '|', '_', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', '_', '_', '_', '_', '-', '-', '`', '`', ' ', ' ', ' ', ' ', '\'', '-', '-', '`', '`', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', ' ', '-', '-', '-', '-', '`', ' ', ' ', ' ', ' ', '`', '`', '-', '-', '-', ',', '_', '_', '_', '|', '_', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {'-', '`', '-', '-', '`', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', '-', '-', '-', '_', '_', ' ', ',', '-', '-', '`', '\'', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', '_', '_', '_', '_', '_', '-', '`', '\'', ' ', ' ', ' ', ' '}
    };
    for (int i = 0; i < tower.length; i++) {
      for (int j = 0; j < tower[0].length; j++) {
        System.out.print(tower[i][j]);
      }
      try{
        Thread.sleep(50);
      }catch(Exception e){}
      System.out.println();
    }

    return tower.length;
  }

  /**
   * Funcion que imprime por pantalla la imagen de una calavera con una espada corta
   * @return la longitud vertical de la imagen
   */
  public static int skull() {
    char[][] skull = new char[][]{
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ',', '-', '-', '.', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '{', ' ', ' ', ' ', ' ', '}'},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'K', ',', ' ', ' ', ' ', '}'},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', '~', 'Y', '`', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ',', ' ', ' ', ' ', '/', ' ', ' ', ' ', '/', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '{', '_', '\'', '-', 'K', '.', '_', '_', '/', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', '/', '-', '.', '_', '_', 'L', '.', '_', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', '\'', ' ', '/', '`', '\\', '_', '}', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', '\'', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', '_', '_', ' ', ' ', ' ', '/', ' ', ' ', '\'', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ',', '-', '\'', '~', '~', '~', '~', ' ', ' ', ' ', ' ', '~', '~', '/', ' ', ' ', '\'', ' ', '/', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ',', '\'', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', '`', '~', '~', '~', ' ', ' ', '\'', ',', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', '(', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'Y', ' ', ' ', ' ', ' '},
      {' ', ' ', '{', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'I', ' ', ' ', ' ', ' '},
      {' ', '{', ' ', ' ', ' ', ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', ',', ' ', ' '},
      {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '\'', ',', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ')', ' ', ' '},
      {' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ',', '.', '.', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ', '_', '_', '.', ' ', 'Y', ' ', ' ', ' '},
      {' ', '|', ' ', ' ', ' ', ' ', '.', ',', '_', '.', '/', ' ', ' ', 'Y', ' ', '\'', ' ', '/', ' ', '^', 'Y', ' ', ' ', ' ', 'J', ' ', ' ', ' ', ')', '|', ' ', ' ', ' '},
      {' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '\'', ' ', '/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', '|', ' ', ' ', ' '},
      {' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'L', '_', '/', ' ', ' ', ' ', ' ', '.', ' ', '_', ' ', '(', '_', ',', '.', '\'', '(', ' ', ' ', ' '},
      {' ', ' ', ' ', '\\', ',', ' ', ' ', ' ', ',', ' ', ' ', ' ', ' ', ' ', ' ', '^', '^', '"', '"', '\'', ' ', '/', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ')', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', '\\', '_', ' ', ' ', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ',', 'L', ']', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', '\'', '-', '_', '~', '-', ',', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', ' ', '`', ' ', ' ', ' ', '.', '/', '`', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '`', '\'', '{', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ')', ' ', ' ', ' ', ' ', ' ', ' '},
      {'Z', 'e', 'u', 's', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '^', '^', '\\', '.', '.', '_', '_', '_', ',', '.', '-', '-', '`', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    for (int i = 0; i < skull.length; i++) {
      for (int j = 0; j < skull[0].length; j++) {
        System.out.print(skull[i][j]);
      }
      try{
        Thread.sleep(50);
      }catch(Exception e){}
      System.out.println();
    }

    return skull.length;
  }

  /**
   * procedimiento que imprime por pantalla las lineas necesarias para centrar lo que se haya imprimido con anterioridad
   * @param lines las lineas maximas de la pantalla
   * @param offset las lineas del texto ya escrito por pantalla que se quiere centrar
   */
  public static void center(int lines, int offset) {
    for (int i = 0; i < (lines / 2) - offset; i++) {
      System.out.println("");
    }
  }
}

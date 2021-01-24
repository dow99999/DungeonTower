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

  public static String clear(int lines) {
    String out = "";
    for (int i = 0; i < lines; i++) {
      out += "\n";
    }
    return out;
  }

  public static String initWindow(int lines) {
    String out = "---------------------------------------";

    for (int i = 2; i < lines; i++) {
      out += "\n";
    }

    out += "Cambia el tamano de la ventana hasta que las lineas de arriba esten en el limite superior de la pantalla y este mensaje en el inferior. presiona enter para continuar";

    return out;
  }

  public static String HealthBar(int current, int max) {
    String out = "[";

    for (int i = 0; i < max; i++) {
      out += (i < current) ? "•" : " ";
    }

    out += "]";

    return out;
  }

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

      frame += dir ? 1 : -1;
      System.out.print("Canviant d'habitacio");
      for (int i = 0; i < frame; i++) {
        System.out.print(".");
      }
      System.out.println();
      for (int i = 0; i < screen[0].length; i++) {
        for (int j = 0; j < screen[0][0].length; j++) {
          System.out.print(screen[frame][i][j]);
        }
        System.out.println();
      }

      center(lines, 3);
      
      if (frame == 2 || frame == 0) {
        dir = !dir;
      }
      
      
      
      try {
        Thread.sleep(wait);
      } catch (InterruptedException ex) {
        Logger.getLogger(Visual.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }

  public static void intro(int lines, int wait, int span) {

    boolean horizontal = false;

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
          if (horizontal) {
            System.out.print(title[(i + x) % title.length][j]);
          } else {
            System.out.print(title[i][(j + (x * 7)) % title[0].length]);
          }
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

  public static void center(int lines, int offset) {
    for (int i = 0; i < (lines / 2) - offset; i++) {
      System.out.println("");
    }
  }
}

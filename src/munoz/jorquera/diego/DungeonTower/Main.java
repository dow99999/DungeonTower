/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package munoz.jorquera.diego.DungeonTower;

import munoz.jorquera.diego.DungeonTower.Model.Jugador;

/**
 *
 * @author diego
 */
public class Main {

  public static void main(String[] args) {

    //test1(false);
    //test2(false);
    //test3(false);
    //test4(false);
    //test5(false);
    //test6(false);
    //test7(false);
    test8(true);

  }

  public static void test1(boolean interactiu) {
    System.out.println("--- Test 1 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("........."), interactiu);
  }

  public static void test2(boolean interactiu) {
    System.out.println("--- Test 2 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("...MA.MA."), interactiu);
  }

  public static void test3(boolean interactiu) {
    System.out.println("--- Test3 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("...MB.MA."), interactiu);
  }

  public static void test4(boolean interactiu) {
    System.out.println("--- Test 4 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("MC."), interactiu);
  }

  public static void test5(boolean interactiu) {
    System.out.println("--- Test 5 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("MB.MB.MB...."), interactiu);
  }

  public static void test6(boolean interactiu) {
    System.out.println("--- Test 6 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("PA2MC."), interactiu);
  }

  public static void test7(boolean interactiu) {
    System.out.println("--- Test 7 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("PD1MB.MB.MB...."), interactiu);
  }

  public static void test8(boolean interactiu) {
    System.out.println("--- Test 8 ---");
    Joc j = new Joc(new Jugador());
    j.jugar(GeneradorMapes.crearMapa("...PD1MA....PA1MB.PA1MC...."), interactiu);
  }
}

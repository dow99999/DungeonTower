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
public class Utils {
  
  /**
   * Funcion que devuelve un int a partir de un char que represente un entero
   * @param c el caracter que se quiere convertir
   * @return int el valor del char
   * @throws NumberFormatException en el caso de que el char no sea un numero valido
   */
  public static int valueOfChar(char c) throws NumberFormatException{
    return Integer.parseInt(new String(new char[] { c }));
  }
  
  /**
   * Procedimiento que imprime por pantalla una matriz de chars formada a partir de un String, esta funcion no se usa en el juego en si
   * pero se ha dejado ya que con ella se ha convertido el ASCIIart en un formato con el que se pueda trabajar mejor.
   * @param input el String que se quiere convertir
   */
  public static void printStringToCharMatrix(String input){
    String[] lined = input.split("\n");
    int maxLength = 0;
    char aux;
    
    //Primero buscamos la linea mas larga, que es la que determinara la longitud de la matriz
    for(int i = 0; i < lined.length; i++){
      if(lined[i].length() > maxLength){
        maxLength = lined[i].length();
      }
    }
    
    System.out.println("{"); //abrimos la matriz
    for(int i = 0; i < lined.length; i++){
      System.out.print("  { "); //empieza un array interior
      for(int j = 0; j < maxLength; j++){
        if(j < lined[i].length()){
          aux = lined[i].charAt(j);
          System.out.print("'");
          switch(aux){ //en el caso de ser un caracter que de problemas como \ o ' escapamos el caracter con una \
            case '\\':
            case '\'':
              System.out.print("\\");
            default:
              System.out.print(lined[i].charAt(j));
          }
        } else {
          System.out.print("' ");
        }
        System.out.print((j == maxLength - 1 ? "'}" : "',")); //colocamos una coma si no hemos llegado al final interior; en caso contrario cerramos el array interior
      }
      if(i != lined.length - 1)
        System.out.println(","); //colocamos una coma si no hemos llegado al final de la matriz
    }
    
    System.out.println("\n}"); //cerramos la matriz
  }
}

package Project.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private int personas;
    private String magnitud;
    HashMap<String,Double> lista_de_valores_y_propietario = new HashMap<String,Double>();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
        
    }

    public void menu(){
        boolean menuon = true;
        Scanner scaneo = new Scanner(System.in);
        while (menuon) {
            System.out.println("1)Magnitud\n2)lista de valores\n3)Media\n4)Varianza\n5)Desviación Estandad\n6)lista de usuarios\n7)Salir");
        switch (scaneo.nextLine()) {
            case "1":
                System.out.println("Introduce una magnitud:");
                setMagnitud(scaneo.nextLine()); 
                break;
            case "2":
                if (getMagnitud() != null) {
                    int personas;
                    while (true) {
                         try {
                        System.out.println("Numero de personas a declarar:");
                        personas  = scaneo.nextInt();
                        this.personas = personas;
                        break;
                    } catch (Exception e) {
                        System.out.println("Esto no es un entero que podamos usar!\n");
                    }
                    }
                    
                    for (int i  = 0; i<personas;i++) {
                        while (lista_de_valores_y_propietario.size()==i) {
                            try {
                            scaneo.nextLine();
                            System.out.println("Nombre del sujeto y seguidamente su "+magnitud+". Faltan "+(personas-i)+" Para definir.");
                            String nombre =  scaneo.nextLine();
                            Double valor = scaneo.nextDouble();


                            lista_de_valores_y_propietario.put(nombre, valor);
                        } catch (Exception e) {
                            System.out.println("Has de proporcionar un numero decimal correcto.\n");
                        }
                        System.out.println("valores del diccionario:"+lista_de_valores_y_propietario.toString());
                        }
                    }
                    System.out.println("\nSe han añadido todos los usuario con exito!\n");
                    
                }else{
                    System.out.println("Has de añadir una magnitud para continuar");
                }
                scaneo.nextLine();
                break;
            case "3":
                if (lista_de_valores_y_propietario.size() != 0) {
                    System.out.println("La media de "+magnitud+" de:\n"+lista_de_valores_y_propietario.toString()+"\nEs de:");
                    double Media;
                    Double suma = 0.0;
                    for (Map.Entry<String,Double> set: lista_de_valores_y_propietario.entrySet()) {
                        suma += set.getValue();
                    }
                    System.out.println(suma);
                    Media = personas/2;
                    System.out.println(Media);
                    
                }else{
                    System.out.println("Has de hacer una lista con valores para conseguir una media");
                }
                break;
            case "4":
                
                break;
            case "5":
                
                break;
            case "6":
                break;
            case "7":
                scaneo.close();
                break;
        
            default:
                break;
        }
        }
        
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }
    public String getMagnitud() {
        return magnitud;
    }
    
}


class Media{

}

class Varianza{

}

class DesviacionE{

}
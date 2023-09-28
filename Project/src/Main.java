package Project.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private String magnitud;
    private double media;
    HashMap<String,Double> lista_de_valores_y_propietario = new HashMap<String,Double>();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
        
    }

    public void menu(){
        boolean menuon = true;
        Scanner scaneo = new Scanner(System.in);
        while (menuon) {
            System.out.println("1)Magnitud\n2)lista de valores\n3)Media\n4)Varianza\n5)Desviación Estandar\n6)lista de usuarios\n7)Salir");
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
                        break;
                    } catch (Exception e) {
                        System.out.println("Esto no es un entero que podamos usar!\n");
                        scaneo.nextLine();
                    }
                    }
                    
                    for (int i  = 0; i<personas;i++) {
                        while (lista_de_valores_y_propietario.size()==i) {
                            try {
                            scaneo.nextLine();
                            System.out.println("Nombre del sujeto y seguidamente su "+magnitud+". Faltan "+(personas-i)+" Para definir.");
                            String nombre =  scaneo.nextLine();
                            System.out.println("Ahora el valor de la magnitud:");
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
                //
            case "3":
                Double suma_total = 0.0;
                for (HashMap.Entry<String,Double> entry: lista_de_valores_y_propietario.entrySet()) {
                    suma_total += entry.getValue();
                    System.out.println(suma_total);
                }
                media = suma_total / (double) lista_de_valores_y_propietario.size();
                System.out.println("La media de "+magnitud+" de la lista de nuestro voluntarios es: "+media+".\n");
                break;
            case "4":
                    if (lista_de_valores_y_propietario.size()!=0) {
                        System.out.println("La varianza de la lista de valores es: "+getVarianza()+".\n");
                    }else{
                        System.out.println("La lista ha de tener valores.\n");

                    }
                break;
            case "5":
                    if (lista_de_valores_y_propietario.size()!=0) {
                        double desviacionEstandar = Math.sqrt(getVarianza());
                        System.out.println("La desviación estándar es: " + desviacionEstandar+".\n");
                    }else{
                        System.out.println("La lista ha de tener valores.\n");

                    }
                break;
            case "6":
                    System.out.println("Lista de personas y sus datos:");
                    for (HashMap.Entry<String,Double> entry: lista_de_valores_y_propietario.entrySet()){
                        System.out.println("Nombre: "+entry.getKey()+"       "+magnitud+": "+entry.getValue());
                    }
                    System.out.println();
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

    public double getVarianza() {
        double sumaDiferenciasCuadrado = 0;
                    for (HashMap.Entry<String,Double> entry: lista_de_valores_y_propietario.entrySet()) {
                        sumaDiferenciasCuadrado += Math.pow(entry.getValue() - media, 2);
                    }
                    double varianza = sumaDiferenciasCuadrado / lista_de_valores_y_propietario.size();
        return varianza;
    }
    
}
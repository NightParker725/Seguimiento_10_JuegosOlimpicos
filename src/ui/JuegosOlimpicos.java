package ui;
import model.*;
import model.ListaPaises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JuegosOlimpicos {
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        menu();
    }
    public static void mostrarMedalleria(ArrayList<Pais> paises) {
        System.out.println("-----------------------------");
        Collections.sort(paises, (a, b) -> {
            int criteria1 = b.getMedallas().compareTo(a.getMedallas());
            if(criteria1 == 0){
                int criteria2 = b.getCantidad() - a.getCantidad();
                if(criteria2 == 0){
                    int criteria3 = a.getNombre().compareTo(b.getNombre());
                    return criteria3;
                }else {
                    return criteria2;
                }
            }else {
                return criteria1;
            }
        });
        paises.forEach(pais -> {
            System.out.println(pais.getNombre() + " " + pais.getMedalla() + " " + pais.getCantidad());
        });
    }
    public static void mostrarTotalMedallas(ArrayList<Pais> paises) {
        System.out.println("-----------------------------");

        Collections.sort(paises, (a, b) -> {
            int criteria1 = b.getCantidad() - a.getCantidad();
            if (criteria1 == 0) {
                int criteria2 = a.getNombre().compareTo(b.getNombre());
                return criteria2;
            } else {
                return criteria1;
            }
        });
        paises.forEach(pais -> {
            System.out.println(pais.getNombre() + " " + pais.getMedalla() + " " + pais.getCantidad());
        });
    }
    public static void mostrarPaises(ArrayList<Pais> paises) {
        System.out.println("-----------------------------");
        Medalleria.selectionSort(paises);
        paises.forEach(pais -> {
            System.out.println(pais.getNombre() + " " + pais.getMedalla() + " " + pais.getCantidad());
        });
    }
    public static void menu() throws IOException {
        ListaPaises listaPaises = new ListaPaises();
        listaPaises.load();
        ArrayList<Pais> paises = new ArrayList<>();
        int opt;
        do {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("Bienvenido al sistema de los juegos olimpicos Paris 2024");
            System.out.println("Por favor seleccione una de las opciones a continuacion: ");
            System.out.println("1. Ingresar un pais\n2. Mostrar medalleria\n3. Mostrar total de medallas\n4. Mostrar paises\n5. Salir");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            opt = lector.nextInt();
            lector.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Porfavor, ingrese la informacion del pais de esta forma de ejemplo:\nJapon::Oro::4");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    String input = lector.nextLine();
                    String[] data = input.split("\\:\\:");
                    paises.add(new Pais(data[0], data[1], Integer.parseInt(data[2])));
                    //System.out.println(Arrays.toString(data));
                    listaPaises.getPaises().add(
                            new Pais(data[0], data[1], Integer.parseInt(data[2]))
                    );
                    listaPaises.save();
                    break;
                case 2:
                    mostrarMedalleria(paises);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    mostrarTotalMedallas(paises);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    mostrarPaises(paises);
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                case 5:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Gracias por usar el sistema de los juegos olimpicos Paris 2024");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Opcion incorrecta o desconocida");
                    break;
            }
        }while (opt != 5);
    }
}
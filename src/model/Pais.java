package model;

import java.util.Comparator;

public class Pais  implements Comparator<Pais>, Comparable<Pais>{
    //Attributes
    private String nombre;
    private String medallas;
    private int cantidad;

    //Methods
    public Pais(String nombre, String medallas, int cantidad) {
        this.nombre = nombre;
        switch (medallas){
            case "Oro":
                this.medallas = "c";
                break;
            case "Plata":
                this.medallas = "b";
                break;
            default:
                this.medallas = "a";
                break;
        }
        this.cantidad = cantidad;
    }
    //getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedallas() {
        return medallas;
    }

    public String getMedalla(){
        String n;
        switch (this.medallas){
            case "c":
                n = "Oro";
                break;
            case "b":
                n = "Plata";
                break;
            default:
                n = "Bronce";
                break;
        }
        return n;
    }

    public void setMedallas(String medallas) {
        this.medallas = medallas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    //Strings
    public int compareTo(Pais o) {
        //this comparado con o
        int criteria1 = this.cantidad - o.cantidad;
        if (criteria1 == 0) {
            int criteria2 = this.medallas.compareTo(o.medallas);
            if (criteria2 == 0) {
                int criteria3 = this.nombre.compareTo(o.nombre);
                return criteria3;
            } else {
                return criteria2;
            }
        }
        else{
            return criteria1;
        }
    }

    @Override
    //Enteros
    public int compare(Pais a, Pais b){
        if (a.getCantidad() - b.getCantidad() == 0) {
            return 0;
        }
        else{
            return a.getCantidad() - b.getCantidad();
        }
    }

}

package model;
import java.util.ArrayList;
import java.util.Arrays;
public class Medalleria {
    //Methods
    public static ArrayList<Pais> selectionSort(ArrayList<Pais> paises){
        int n = paises.size();

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(paises.get(j).getNombre().compareTo(paises.get(i).getNombre()) < 0){
                    Pais min = paises.get(j);
                    Pais max = paises.get(i);
                    paises.set(j, max);
                    paises.set(i, min);
                }
            }
        }
        return paises;
    }
}

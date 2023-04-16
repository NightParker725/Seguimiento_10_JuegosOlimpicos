package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ListaPaises {
    static String folder = "data";
    static String path = "data/data.txt";

    ArrayList<Pais> paises;

    public ListaPaises() {
        paises = new ArrayList<>();
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        String data = "";
        for (int i = 0; i < paises.size(); i++) {
            data += paises.get(i).getNombre() + "::" + paises.get(i).getMedallas() + "::" + paises.get(i).getCantidad() + "\n";
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }

    public void load() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
                String[] arr = line.split("::");
                System.out.println(Arrays.toString(arr));
                paises.add(
                        new Pais(arr[0], arr[1], Integer.parseInt(arr[2]))
                );
                content += line + "\n";
            }
            System.out.println(paises.size());
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public void show() {
        for (Pais s : paises) {
            System.out.println(s.getNombre());
        }
    }
}


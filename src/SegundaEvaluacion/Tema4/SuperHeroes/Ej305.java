package SegundaEvaluacion.Tema4.SuperHeroes;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej305 {
    public static void main(String[] args) throws IOException {
        ArrayList<SuperHeroe> listaSuperHeroes = new ArrayList<>();


        BufferedReader lectorSuperHeroes = new BufferedReader(new FileReader("superheroes.txt"));
        String linea;
        while ((linea = lectorSuperHeroes.readLine())!= null){
            cargarSuperHeroes(linea, listaSuperHeroes);
        }



        URL url=new URL("https://mural.uv.es/franpevi/index.html");
        BufferedReader lectorPagina = new BufferedReader(new InputStreamReader(url.openStream()));

        String patron = "src=\"([^\"]*)\".*class=\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(patron);

        while ((linea = lectorPagina.readLine())!= null){
            linea = linea.strip();
            if(linea.startsWith("<img")){
                Matcher matcher = pattern.matcher(linea);
                while (matcher.find()) {
                    for (SuperHeroe superHeroe : listaSuperHeroes) {
                        if (superHeroe.id.equals(matcher.group(2))) {
                            superHeroe.imagen = matcher.group(1);
                        }
                    }
                }
            }
        }

        ArrayList<SuperHeroe> listaMarvel = new ArrayList<>();
        ArrayList<SuperHeroe> listaDC = new ArrayList<>();

        listaSuperHeroes.stream().filter(superHeroe -> superHeroe.id.startsWith("M")).forEach(listaMarvel::add);
        listaSuperHeroes.stream().filter(superHeroe -> superHeroe.id.startsWith("D")).forEach(listaDC::add);

       cargarPagina("marvel.html", listaMarvel);
       cargarPagina("dc.html", listaDC);
    }

    public static void cargarSuperHeroes(String linea, ArrayList<SuperHeroe> listaSuperHeroes){
        String[] vector = linea.split(";");
        listaSuperHeroes.add(new SuperHeroe(vector[0], vector[1], vector[2], vector[3], ""));
    }

    public static void cargarPagina(String ruta, ArrayList<SuperHeroe> lista) throws IOException {
        File archivo = new File(ruta);
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
        escritor.write(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <title>Pagina "+ruta.split("\\.")[0] +"</title>\n" +
                        "    <style>\n" +
                        "        table { width: 100%; border-collapse: collapse; }\n" +
                        "        th, td { border: 1px solid black; padding: 8px; text-align: left; }\n" +
                        "        td img { width: 80%; height: auto; display: block; margin: 0 auto; }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<table>\n" +
                        "    <tr>\n" +
                        "        <th>ID</th>\n" +
                        "        <th>Nombre</th>\n" +
                        "        <th>Imagen</th>\n" +
                        "        <th>Descripción</th>\n" +
                        "    </tr>\n"
        );

        for (SuperHeroe superHeroe : lista) {
            escritor.write(
                    "    <tr>\n" +
                            "        <td>" + superHeroe.id + "</td>\n" +
                            "        <td>" + superHeroe.nombre + " (" + superHeroe.identidad + ")</td>\n" +
                            "        <td><img src=\"" + superHeroe.imagen + "\" class=\"" + superHeroe.id + "\"></td>\n" +
                            "        <td>" + superHeroe.descripcion + "</td>\n" +
                            "    </tr>\n"
            );
        }

        escritor.write(
                "</table>\n" +
                        "</body>\n" +
                        "</html>"
        );

        escritor.flush();
        escritor.close();

        ProcessBuilder pb = new ProcessBuilder("firefox",archivo.getAbsolutePath());
        pb.start();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import clases.Cancion;
import clases.ListaCanciones;
import clases.NodoD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author gerardo
 */
public class CancionDOM {

    private String pathFile =  getClass().getResource("/datos/datos.xml").toString();//"C:\\datos\\datos.xml";

    public void addAll(ListaCanciones lista, String pathFile2) {
        Cancion cancion;
        NodoD nodo;

        try {
            Document d = DOMHelper.getDocument(pathFile);
            Element canciones = d.getDocumentElement();
            lista.irPrimero();
            nodo = lista.getActual();
            while (nodo != null) {
                cancion = nodo.getDatos();

                Element item = d.createElement("cancion");

                Element id = d.createElement("id");
                id.appendChild(d.createTextNode("" + cancion.getId()));
                item.appendChild(id);

                Element titulo = d.createElement("titulo");
                titulo.appendChild(d.createTextNode(cancion.getTitulo()));
                item.appendChild(titulo);

                Element genero = d.createElement("genero");
                genero.appendChild(d.createTextNode(cancion.getGenero()));
                item.appendChild(genero);

                Element artista = d.createElement("artista");
                artista.appendChild(d.createTextNode(cancion.getArtista()));
                item.appendChild(artista);

                Element album = d.createElement("album");
                album.appendChild(d.createTextNode(cancion.getAlbum()));
                item.appendChild(album);

                Element year = d.createElement("year");
                year.appendChild(d.createTextNode("" + cancion.getYear()));
                item.appendChild(year);

                Element ruta = d.createElement("ruta");
                ruta.appendChild(d.createTextNode(cancion.getRuta()));
                item.appendChild(ruta);

                canciones.appendChild(item);

                nodo = nodo.getSig();
            } // fin del while

            DOMHelper.saveXMLContent(d, pathFile2);
        } catch (Exception e) {
            System.err.println("fallo algo");

        }
    }

    public List<Cancion> getAll(String pathFile2) {

        List<Cancion> canciones = new ArrayList();
        Cancion cancion;

        try {

            Document document = DOMHelper.getDocument(pathFile2);
            NodeList nodelist = document.getElementsByTagName("cancion");
            for (int i = 0; i < nodelist.getLength(); i++) {

                Element s = (Element) nodelist.item(i);
                cancion = new Cancion();

                cancion.setId(Integer.parseInt(s.getElementsByTagName("id").item(0).getTextContent()));
                cancion.setTitulo(s.getElementsByTagName("titulo").item(0).getTextContent());
                cancion.setArtista(s.getElementsByTagName("artista").item(0).getTextContent());
                cancion.setAlbum(s.getElementsByTagName("album").item(0).getTextContent());
                cancion.setGenero(s.getElementsByTagName("genero").item(0).getTextContent());
                cancion.setYear(Integer.parseInt(s.getElementsByTagName("year").item(0).getTextContent()));
                cancion.setRuta(s.getElementsByTagName("ruta").item(0).getTextContent());

                canciones.add(cancion);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }

        return canciones;

    }
}

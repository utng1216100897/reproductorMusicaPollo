/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author gerardo
 */
public class MP3 {

    private String filename;
    private Player player;

    public MP3(String filename) {
        this.filename = filename;
    }

    public void close() {
        if (player != null) {
            player.close();
        }
    }

    public void play() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);

        } catch (Exception e) {
            System.err.println("error al intentar cargar el archivo: " + filename);
            System.err.println(e.getMessage());

        }

        new Thread() {
            public void run() {
                try {
                    player.play();

                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
            }
        }.start();
    }
    
    public void pausa() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);

        } catch (Exception e) {
            System.err.println("error al intentar cargar el archivo: " + filename);
            System.err.println(e.getMessage());

        }

        new Thread() {
            public void run() {
                try {
                    player.close();

                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
            }
        }.start();
    }


}

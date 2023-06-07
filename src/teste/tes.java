/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import Controller.MusicaController;

/**
 *
 * @author Administrador
 */
public class tes {

    public static void main(String[] args) {
        MusicaController music = new MusicaController();

        music.add("Casa nova", 2.45);
        music.add("Almir sate", 2.2);
        music.add("Blue", 2.1);
        System.out.println(music.toString());
        music.ordAlfabetic();
        System.out.println(music.toString());
        music.ordDuracao();
        System.out.println(music);


        

    }
}

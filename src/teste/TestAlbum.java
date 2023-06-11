/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import Controller.AlbumController;
import Controller.MusicaController;
import DTO.MusicDTO;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class TestAlbum {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        AlbumController album = new AlbumController();
        MusicaController music = new MusicaController();

        album.cria("Sertanejo");

        music.add("Casa nova", 2.45);
        //music.add("Almir sate", 2.2);
        album.cria("Modao");

        System.out.println(music);
        album.addMusiAlbum("Modao", music);
        System.out.println(album.busca("modao"));




        System.out.println(album);
        
    }
          
    
}

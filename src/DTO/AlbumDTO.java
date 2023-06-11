/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Controller.MusicaController;

/**
 *
 * @author Administrador
 */
public class AlbumDTO {

    private String nome;

    private MusicaController musicas;

    private AlbumDTO anterior;
    private AlbumDTO proxima;
    
    
    
    
    

    public AlbumDTO(MusicaController musicas) {
        this.musicas =  musicas;
    }

    public AlbumDTO() {
    }


    public AlbumDTO(String nome) {
        this.nome = nome;
    }

    public AlbumDTO(String nome, MusicaController  musicas) {
        this.nome = nome;
        this.musicas = musicas;
    }

    public AlbumDTO getAnterior() {
        return anterior;
    }

    public void setAnterior(AlbumDTO anterior) {
        this.anterior = anterior;
    }

    public AlbumDTO getProxima() {
        return proxima;
    }

    public void setProxima(AlbumDTO proxima) {
        this.proxima = proxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MusicaController  getMusicas() {
        return musicas;
    }

    public void setMusicas(MusicaController  musicas) {
        this.musicas = musicas;
    }


    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", musicas=" + musicas +
                '}';
    }
}

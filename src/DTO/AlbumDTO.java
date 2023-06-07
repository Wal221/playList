/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Administrador
 */
public class AlbumDTO {
    
    private String Artista;
    
    private MusicDTO musicas;
    
    private AlbumDTO album;

    
    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }
    

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public MusicDTO getMusicas() {
        return musicas;
    }

    public void setMusicas(MusicDTO musicas) {
        this.musicas = musicas;
    }
    
    
    
}

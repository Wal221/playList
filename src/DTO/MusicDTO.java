/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Administrador
 */
public class MusicDTO {

    private String nome;

    private Double duracaoMusic;

    private MusicDTO anterior;

    private MusicDTO proxima;

    public MusicDTO(){
        
    }
    
    public MusicDTO(String nome){
        this.nome = nome;
        
    }
    
    public MusicDTO (String nome, Double duracao){
        this.duracaoMusic = duracao;
        this.nome = nome;
        
    }
    
    public MusicDTO getAnterior() {
        return anterior;
    }

    public void setAnterior(MusicDTO anterior) {
        this.anterior = anterior;
    }

    public MusicDTO getProxima() {
        return proxima;
    }

    public void setProxima(MusicDTO proxima) {
        this.proxima = proxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDuracaoMusic() {
        return duracaoMusic;
    }

    public void setDuracaoMusic(Double duracaoMusic) {
        this.duracaoMusic = duracaoMusic;
    }



}

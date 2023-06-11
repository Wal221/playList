/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.AlbumDTO;
import DTO.MusicDTO;

/**
 *
 * @author Administrador
 */
public class AlbumController {

    private AlbumDTO primeiro;

    private AlbumDTO ultimo;

    private AlbumDTO antecessor;

    private int cont;





    public void cria(String nome) {

        AlbumDTO novo= new AlbumDTO(nome);

        if (cont == 0) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            /**
             * Faço o ultimo elemento aponta para o proximo que sera inserido
             */
            this.ultimo.setProxima(novo);
            //guardo a referencia do ultimo elemento antes de atualizar , ja que sendo ele o antecessor
            //e preciso apontar para o anterior , pois e uma lista duplamente encadeada
            this.antecessor = this.ultimo;
            //Atualizo o novo elemento , ja que cada novo elemento e inserido usando  a variavel ultimo
            this.ultimo = novo;
            //Com o novo elemento inserido sendo ele o ultimo, faço o seu ponteiro anterior aponta para o
            //elemento anterior da lista
            this.ultimo.setAnterior(antecessor);

        }
        cont++;
    }

    public AlbumDTO busca(String elemento) {
        AlbumDTO busca = this.primeiro;

        for (int i = 0; i < this.cont; i++) {
            if (busca.getNome().equalsIgnoreCase(elemento)) {
                System.out.println(busca.getMusicas());
                return busca;
            }
            busca = busca.getProxima();
        }
        return null;

    }
    public void addMusiAlbum( String nameAlbum,MusicaController music){
        AlbumDTO adic = busca(nameAlbum);

        adic.setMusicas(music);

    }
    
      public void remover(String nome) {
          AlbumDTO excluir = busca(nome);
        if(cont == 0){
            System.out.println("Nao existe albuns");
            return;
        }

          //se ouver somente um elemento na lista sera removido
         if(excluir.getAnterior() == null && excluir.getProxima()== null){
            this.primeiro = null;
            this.ultimo = null;
            cont --;

        }
         //remove o primeiro elemento
         else if(excluir.getAnterior() == null){
             this.primeiro = this.primeiro.getProxima();
             this.primeiro.setAnterior(null);
             this.cont --;


        }//remove o ultimo elemento
         else if(excluir.getProxima() == null){

          this.ultimo = this.ultimo.getAnterior();
          //vale ressaltar que essa forma de fazer o elemento aponta para o anterior , e equivalente a
             //fazer a elemento aponta para o null , ja que e o ultimo elemento
           this.ultimo.setProxima(excluir.getProxima());
             cont --;

        }
        else {
            //para remover um elemento do meio da lista
            excluir.getAnterior().setProxima(excluir.getProxima());
            excluir.getProxima().setAnterior(excluir.getAnterior());
            excluir = excluir.getProxima();
             cont --;

        }
    }
      
      public String mostrar(int aux) {
        StringBuilder builder = new StringBuilder();
        AlbumDTO atual = this.primeiro;
         
         builder.append("Nome Album:" + atual.getNome() + "\t");
        for (int i = 0; i < this.cont; i++) {

            if (i == aux) {
               
                builder.append("Musicas do album: " + atual.getMusicas().mostrar(aux)+ ";");

            }
            atual = atual.getProxima();
        }
        return builder.toString();
    }

      
       public String toString() {
        if (this.cont == 0) {
            return " Nao a Albums";

        }
        
        StringBuilder builder = new StringBuilder();
         AlbumDTO atual = this.primeiro;

        // builder.append("Nome do Album:" + atual.getNome() + " \n");
        for (int i = 0; i < this.cont ; i++) {
            
            builder.append( atual.getNome() + "\n ");
            atual = atual.getProxima();

        }
        
        return builder.toString();

    }
     public void ordena(){

     }
      


}

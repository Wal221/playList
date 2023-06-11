/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.MusicDTO;

/**
 *
 * @author Administrador
 */
public class MusicaController {

    private MusicDTO primeiro;

    private MusicDTO ultimo;
    private MusicDTO antecessor;

    public int cont;

    public MusicaController() {
    }

    public void add(String nome, Double duracao) {

        MusicDTO nova = new MusicDTO(nome, duracao);

        if (cont == 0) {
            this.primeiro = nova;
            this.ultimo = nova;
        } else {
            /**
             * Faço o ultimo elemento aponta para o proximo que sera inserido
             */
            this.ultimo.setProxima(nova);
            //guardo a referencia do ultimo elemento antes de atualizar , ja que sendo ele o antecessor
            //e preciso apontar para o anterior , pois e uma lista duplamente encadeada
            this.antecessor = this.ultimo;
            //Atualizo o novo elemento , ja que cada novo elemento e inserido usando  a variavel ultimo
            this.ultimo = nova;
            //Com o novo elemento inserido sendo ele o ultimo, faço o seu ponteiro anterior aponta para o
            //elemento anterior da lista
            this.ultimo.setAnterior(antecessor);

        }
        cont++;
    }

    public MusicDTO busca(String elemento) {
        MusicDTO busca = this.primeiro;

        for (int i = 0; i < this.cont; i++) {
            if (busca.getNome().equalsIgnoreCase(elemento)) {

                return busca;
            }
            busca = busca.getProxima();
        }
        return null;

    }

//    public MusicDTO passarMusica(int aux) {
//        MusicDTO prox = this.primeiro;
//        aux = 0;
//        
//        if(cont == 0){
//            return null ;
//        }
//        if(aux == 0){
//            prox = prox.getProxima();
//        }else if(aux == 1){
//            prox = prox.getAnterior();
//        }
//        return prox;
//      
//                
//
//    }

    public void remover(String nome) {
          MusicDTO excluir = busca(nome);
        if(cont == 0){
            System.out.println("Play List vazia");
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

    public void tamanho() {

    }

    public Double duracaoMusica() {
        return null;
    }

    public void musicaAleatoria() {

    }

    public String mostrar(int aux) {
        StringBuilder builder = new StringBuilder();
        MusicDTO atual = this.primeiro;

        for (int i = 0; i < this.cont; i++) {

            if (i == aux) {
                builder.append("Nome da musica:" + atual.getNome() + "\n");
                builder.append("Duração: " + atual.getDuracaoMusic() + ";");

            }
            atual = atual.getProxima();
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        if (this.cont == 0) {
            return " Não a musicas na playList";

        }
        StringBuilder builder = new StringBuilder();
        MusicDTO atual = this.primeiro;

        for (int i = 0; i < this.cont - 1; i++) {
            builder.append("Nome da musica:" + atual.getNome() + " \n");
            builder.append("Duração: " + atual.getDuracaoMusic() + "\n ");
            atual = atual.getProxima();

        }
        builder.append("Nome da musica:" + atual.getNome()+"\n");
        builder.append("Duração: " + atual.getDuracaoMusic()+ "\n");
        builder.append("\n \t");
        return builder.toString();

    }

    public void ordDuracao() {
        MusicDTO atual = this.primeiro;
        //tenho de fazer o atual caminhar
        for (MusicDTO i = atual; i != null; i = i.getProxima()) {
            MusicDTO menor = i;

            for (MusicDTO j = i.getProxima(); j != null; j = j.getProxima()) {
                if (j.getDuracaoMusic() < menor.getDuracaoMusic()) {
                    menor = j;
                }
            }
            Double auxDuracao = i.getDuracaoMusic();
            String nomeMusic = i.getNome();
            i.setNome(menor.getNome());
            i.setDuracaoMusic(menor.getDuracaoMusic());

            menor.setNome(nomeMusic);
            menor.setDuracaoMusic(auxDuracao);
        }

    }

    public void ordAlfabetic() {
        MusicDTO atual = this.primeiro;

        for (MusicDTO i = atual; i != null; i = i.getProxima()){
            MusicDTO menor = i;//Bolsa nova
            //vou recupera os nomes e sempre guarda a primeira letra para ser comparadas

            for(MusicDTO j = i.getProxima(); j != null ; j = j.getProxima()){
                //a primeira palavra a ser comparada dever ser atualizada nesse segundo
                //for ja que o segundo for so vai termina quando o proximo obj for null
                char primeira = menor.getNome().charAt(0);
               
                char seg = j.getNome().charAt(0);
                if(seg < primeira) {
                    menor = j; 
                }
            }
            String nomeMusic = i.getNome();// Bolsa nova
            Double auxDuracao = i.getDuracaoMusic(); // duração da musica bolsa nova


            i.setNome(menor.getNome()); // na primeira posição como e a primeira volta na primeira posição o i vai receber
                                                 // o Almir sater
            i.setDuracaoMusic(menor.getDuracaoMusic()); // recebe e duração da menor musica

            menor.setNome(nomeMusic); //menor vai receber o nome da musica que era a maior
            menor.setDuracaoMusic(auxDuracao);// vai receber a duração da musica que era a maior
            
        }
        

    }

    public void excluir(String elemento) {

        MusicDTO excluir = busca(elemento);
        if (cont == 0) {
            System.out.println("lista vazia");
            return;
        }

        //se ouver somente um elemento na lista sera removido
        if (excluir.getAnterior() == null && excluir.getProxima() == null) {
            this.primeiro = null;
            this.ultimo = null;
            cont--;

        } //remove o primeiro elemento
        else if (excluir.getAnterior() == null) {
            this.primeiro = this.primeiro.getProxima();
            this.primeiro.setAnterior(null);
            this.cont--;

        }//remove o ultimo elemento
        else if (excluir.getProxima() == null) {

            this.ultimo = this.ultimo.getAnterior();
            //vale ressaltar que essa forma de fazer o elemento aponta para o anterior , e equivalente a
            //fazer a elemento aponta para o null , ja que e o ultimo elemento
            this.ultimo.setProxima(excluir.getProxima());
            cont--;

        } else {
            //para remover um elemento do meio da lista
            excluir.getAnterior().setProxima(excluir.getProxima());
            excluir.getProxima().setAnterior(excluir.getAnterior());
            excluir = excluir.getProxima();
            cont--;

        }

    }
}

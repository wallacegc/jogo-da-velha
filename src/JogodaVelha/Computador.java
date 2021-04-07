package JogodaVelha;

import java.util.Random;

public class Computador extends Jogador{

	Random gerador = new Random();
		 
	public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){ //Gravar a posicao jogada no tabuleiro
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }    
    
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
    	 
    	 if (this.getDificuldade()==1) {
    		 // Jogada do computador na dificuldade 1
    		 // vai do inicio ao fim do tabuleiro
    		 // indo de cima para baixo, da esquerda para a direita
        	 for(int coluna=0 ; coluna<3 ; coluna++) {
        		 tentativa[1] = coluna;
        		 for(int linha=0 ; linha<3 ; linha++) {
        			 tentativa[0] = linha;
        			 if(checaTentativa(tentativa, tabuleiro)) {
        				 //Caso o local não foi preenchido
        				 // forca a saida do loop
        				 linha=3;
        				 coluna=3;
        			 }
        				 
        			 
        		 }
    		 
    	 }
    	 }
    	 if (this.getDificuldade()==2) {
    		 // Jogada do computador na dificuldade 2
    		 // vai do fim ao inicio do tabuleiro
    		 // indo de baixo para cima, da  direita para a esquerda
        	 for(int coluna=2 ; coluna>=0 ; coluna--) {
        		 tentativa[1] = coluna;
        		 for(int linha=2 ; linha>=0 ; linha--) {
        			 tentativa[0] = linha;
        			 if(checaTentativa(tentativa, tabuleiro)) {
        				 //Caso o local não foi preenchido
        				 // forca a saida do loop
        				 linha=-1;
        				 coluna=-1;
        			 }
        				 
        			 
        		 }
    		 
    	 }
    	 }
    	 if (this.getDificuldade()==3) 
    		 do {
    			 // jogada do computador na dificuldade 3
    			 // utilizando um numero aleatorio de 0 a 2!
    			 tentativa[1] = gerador.nextInt(3);
    			 tentativa[0] = gerador.nextInt(3);
    		 } while (!checaTentativa(tentativa, tabuleiro));
    	 	 
    		 

    	 
    }
    
    
    
}
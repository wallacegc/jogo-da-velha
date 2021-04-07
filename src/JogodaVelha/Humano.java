package JogodaVelha;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador){ // Criando o jogador
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){ //Gravar a posicao jogada no tabuleiro
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");//Linha a ser jogada
                tentativa[0] = entrada.nextInt();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)// Verifica��o da linha 
                    System.out.println("Linha inv�lida. � 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");//Coluna a ser jogada
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)// Verifica��o da Coluna
                    System.out.println("Coluna inv�lida. � 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; // tem que subtrair, pois a opcao � de 1 a 3, mas a matriz � de 0 a 2!
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))//Caso o local j� foi preenchido
                System.out.println("Esse local j� foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
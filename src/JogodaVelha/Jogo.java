package JogodaVelha;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);

    
    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        
        while( Jogar() );
    }
    
    public void iniciarJogadores(){ //Identificar o jogadores
        System.out.println("Quem vai ser o Jogador 1 ?");
        if(escolherJogador() == 1)
        	// a escolha foi humano
            this.jogador1 = new Humano(1);
        else {
        	// a escolha foi computador
            this.jogador1 = new Computador(1);
            // define a dificuldade
            this.jogador1.setDificuldade(escolherDificuldade());        	
        	
        }
        
        System.out.println("----------------------"); //Identificar o jogadores
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        if(escolherJogador() == 1)
        	// a escolha foi humano
            this.jogador2 = new Humano(2);
        else {
        	// a escolha foi computador
            this.jogador2 = new Computador(2);
            // define a dificuldade
            this.jogador2.setDificuldade(escolherDificuldade());        	
        }
        
    }
    
    public int escolherJogador(){
        int opcao=0;
        
        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente"); // Caso a escolha seja invalida
        }while(opcao != 1 && opcao != 2);
        
        return opcao;
    }

    public int escolherDificuldade(){
        int opcao=0;
        
        do{
            System.out.println("Escolha a dificuldade");
            System.out.println("1,2 ou 3\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2 && opcao != 3)
                System.out.println("Opção inválida! Tente novamente"); // Caso a escolha seja invalida
        }while(opcao != 1 && opcao != 2 && opcao != 3);
        
        return opcao;
    }
    
    public boolean Jogar(){ //Começar o jogo 
        if(ganhou() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+rodada);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
            
            
            if(tabuleiro.tabuleiroCompleto()){ // Caso o jogo seja empatado
                System.out.println("Tabuleiro Completo.");
                if(ganhou() == 0){ // Caso o jogo seja empatado
                    System.out.println("Jogo empatado");
                    return false;
                }
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 )//Identificar qual jogador ganhou
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            
            return false;
        }
            
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){//Checagem das linhas e das colunas
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}

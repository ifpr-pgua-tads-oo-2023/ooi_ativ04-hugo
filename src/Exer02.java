import java.util.Random;
import java.util.Scanner;

public class Exer02{
    static Scanner teclado = new Scanner(System.in);
    static Random rand = new Random(System.currentTimeMillis());

    static int lerQuantidadeJogos(){
        int quantidadeJogos;
        do{
            System.out.println("Digite a quantidade de jogos (1,2,3):");
            quantidadeJogos = teclado.nextInt();
            if(quantidadeJogos < 1 || quantidadeJogos > 3){
                System.out.println("Quantidade inválida!!!");
            }
        }while(quantidadeJogos < 1 || quantidadeJogos > 3);
        return quantidadeJogos;
    }

    static boolean verificarRepeticao(int num, int[] vetor){
        for(int k=0;k<vetor.length;k++){
            if(vetor[k]==num){
                return true;
            }
        }
        return false;
    }

    static boolean verificarEscolhaValida(int num){
        return num>=1 && num<=60;
    }

    static int contarAcertos(int[] escolhas, int[] sorteados){
        int numeroAcertos = 0;
        for(int j=0;j<6;j++){
            for(int k=0;k<6;k++){
                if(escolhas[j]==sorteados[k]){
                    numeroAcertos += 1;
                }
            }
        }
        return numeroAcertos;
    }


    static void imprimeVetor(int[] vetor){
        System.out.print("[");
        for(int i=0;i<vetor.length;i++){
            System.out.print(""+vetor[i]+",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        
        int quantidadeJogos;
        int escolhaUsuario;
        int[][] jogosUsuario;
        boolean repetiuEscolha;
        int numeroAcertos;

        int[] sorteioComputador = new int[6];
        int numeroSorteado;

        quantidadeJogos = lerQuantidadeJogos();

        //alocar a matriz dos jogos
        jogosUsuario = new int[quantidadeJogos][6];

        for(int i=0;i<quantidadeJogos;i++){
            for(int j=0;j<6;j++){
                do{
                    repetiuEscolha = false;
                    System.out.println("Digite a escolha "+(j+1)+" do jogo "+(i+1)+":");
                    escolhaUsuario = teclado.nextInt();
                    
                }while(!verificarEscolhaValida(escolhaUsuario) || verificarRepeticao(escolhaUsuario, jogosUsuario[i]));
                jogosUsuario[i][j] = escolhaUsuario;
            }
        }

        //sorteio do computador
        for(int i=0;i<6;i++){
            do{
                numeroSorteado = (rand.nextInt(60)+1);
            }while(verificarRepeticao(numeroSorteado, sorteioComputador));
            sorteioComputador[i] = numeroSorteado;
        }


        for(int i=0;i<quantidadeJogos;i++){

            numeroAcertos = contarAcertos(jogosUsuario[i], sorteioComputador);

            if(numeroAcertos == 6){
                System.out.println("Ficou rico!!");
            }else if(numeroAcertos == 5){
                System.out.println("Quase lá, mas da pra pagar umas contas...");
            }else{
                System.out.println("Não foi dessa vez!!");
            }
        }


        for(int i=0;i<quantidadeJogos;i++){
            imprimeVetor(jogosUsuario[i]);
        }


        System.out.println("Sorteados...");
        imprimeVetor(sorteioComputador);



        System.out.println("Fim!!!");

    }
}

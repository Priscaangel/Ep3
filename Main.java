import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final String INGENUA = "0";
    private static final String BINARIA = "1";

    public static void main (String [] args) throws IOException {

        FileWriter writerSaida = new FileWriter("saida.txt");

        for (int tarefa = 1000; tarefa <= 99000; tarefa += 1000) {

            String caminhoArquivoEntrada = "entradas/tarefas"+tarefa+".txt"; // Para cada arquivo de entrada
            String caminhoVerificar = "verificar/verificar"+tarefa+".txt";

            String tipoPrograma = args[0]; 
            
            File arquivoEntrada = new File(caminhoArquivoEntrada); 
            File arquivoVerificar = new File(caminhoVerificar);


            long timeInicial = System.currentTimeMillis(); 

            try {
                Scanner sc = new Scanner(arquivoEntrada); 
    
                if (tipoPrograma.equals(BINARIA)) { // Se a opção escolhida for o arranjo...

                    BinarySearchTree <Integer, Integer> bst = new BinarySearchTree<Integer, Integer>(new IntComparator());

                    //cria o dicionário/árvore binária com os valores do arquivo
                    while (sc.hasNext()) {

                        String linha = sc.nextLine();

                        if(!linha.equals("")){
                            int linha2 = Integer.parseInt(linha);
                            bst.insert(linha2, linha2);
                            //System.out.println(linha2);
                        }                       
                    
                    }
                    Scanner sc2 = new Scanner(arquivoVerificar); 

                    //roda o find para os números do arquivo
                    while (sc2.hasNext()) {
                        
                        String linha = sc2.nextLine();
                        int linha2 = Integer.parseInt(linha);

                        Entry <Integer, Integer> entry = bst.find(linha2);

                    }


                }
                if (tipoPrograma.equals(INGENUA)) { // se o tipo da pilha for ingênua... 

                    BuscaIngenua buscaIngenua = new BuscaIngenua();
                    while (sc.hasNext()) { // enquanto houver linhas para serem lidas no documento...
                        String linha= sc.nextLine(); // variável para receber a linha 
                        buscaIngenua.insert(linha);
                    }

                    Scanner sc2 = new Scanner(arquivoVerificar);

                    while (sc2.hasNext()) { // enquanto houver linhas para serem lidas no documento...
                        String linha= sc2.nextLine(); // variável para receber a linha
                        buscaIngenua.find(linha);
                    }


                }
                //escrita dos tempos em um arquivo txt
                long timeFinal = System.currentTimeMillis();
                long tempoTotal = timeFinal - timeInicial;
                writerSaida.write("tempo do arquivo " + tarefa + ": " + tempoTotal + "\n");
                

                sc.close();
            } catch (IOException ex) {
                //LIDAR COM O ERRO
                System.out.println("Error: " + ex.getMessage());
            }
        
        }
        writerSaida.close();
    }
}
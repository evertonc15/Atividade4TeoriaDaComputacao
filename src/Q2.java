import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static List<String> generateChain(int N) {
        //Metodo publico e estatico que gera todas as cadeias de comprimento N.
        //Retorna uma lista de strings.
        List<String> chains = new ArrayList<>();
        //Cria uma lista vazia para armazenar as cadeias geradas.
        generateChainsRecursive("S", N, "", chains);
        //Chama o metodo recursivo para gerar as cadeias, começando com o simbolo inicial "S",
        //comprimento N, uma cadeia atual vazia e a lista para armazenar as cadeias.
        return chains;
        //Retorna a lista com as cadeias geradas.
    }
    private static void generateChainsRecursive(String symbol, int N, String currentChain, List<String> chains) {
        //Metodo privado e recursivo para gerar as cadeias.
        //Recebe o simbolo atual, o comprimento N, a cadeia atual sendo construída e a lista de cadeias.
        if (currentChain.length() == N) {
            //Verifica se a cadeia atual ja atingiu o comprimento desejado.
            chains.add(currentChain);
            //Adiciona a cadeia a lista de cadeias.
            return;
            //Termina a execucao para esta ramificacao da recursao.
        }
        switch (symbol) {
            // Verifica o simbolo atual para decidir como gerar os proximos caracteres.
            case "S":
                //Caso o simbolo atual seja "S" (símbolo inicial):
                generateChainsRecursive("A", N, currentChain + "a", chains);
                // Adiciona "a" a cadeia atual e chama recursivamente o metodo com o simbolo "A".
                generateChainsRecursive("B", N, currentChain + "b", chains);
                //Adiciona "b" a cadeia atual e chama recursivamente o metodo com o simbolo "B".
                if (currentChain.length() + 1 == N) {
                    //Se adicionar "c" completaria exatamente o comprimento desejado:
                    chains.add(currentChain + "c");
                    //Adiciona a cadeia com "c" diretamente a lista.
                }
                break;
            case "A":
                //Caso o simbolo atual seja "A":
                generateChainsRecursive("A", N, currentChain + "a", chains);
                //Adiciona "a" a cadeia atual e chama recursivamente o metodo com o simbolo "A".
                break;
            case "B":
                //Caso o simbolo atual seja "B":
                generateChainsRecursive("B", N, currentChain + "b", chains);
                //Adiciona "b" a cadeia atual e chama recursivamente o metodo com o simbolo "B".
                break;
        }
    }
    public static void main(String[] args) {
        //Metodo principal para testar o codigo.
        int N = 3;
        //Define o comprimento das cadeias a serem geradas.
        List<String> chains = generateChain(N);
        //Gera todas as cadeias de comprimento N usando o metodo `generateChain`.
        System.out.println("Cadeias de comprimento " + N + ": " + chains);
        //Imprime as cadeias geradas no console.
    }
}
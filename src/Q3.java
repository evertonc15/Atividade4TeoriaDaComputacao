import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {
    public static boolean belongsLanguage(Map<String, List<String>> grammar, String initialSymbol, String chain) {
        //Metodo publico e estatico que verifica se uma cadeia pertence a linguagem.
        return checkChain(grammar, initialSymbol, chain, 0);
        //Chama o metodo recursivo para iniciar a verificacao, partindo do simbolo inicial e posicao 0 na cadeia.
    }
    private static boolean checkChain(Map<String, List<String>> grammar, String symbol, String chain, int position) {
        //Metodo privado e recursivo para verificar se a cadeia pode ser gerada pela gramatica.
        if (position == chain.length() && symbol.equals("")) {
            //Caso base 1: Se alcancou o final da cadeia e nao ha mais simbolos para expandir.
            return true;
            //Retorna verdadeiro, indicando que a cadeia pertence a linguagem.
        }
        if (position == chain.length() || symbol.equals("")) {
            //Caso base 2: Se alcancou o final da cadeia ou nao ha mais simbolos, mas o outro ainda nao terminou.
            return false;
            //Retorna falso, indicando que a cadeia nao e valida.
        }
        if (grammar.containsKey(symbol)) {
            //Verifica se o simbolo atual e nao-terminal (ou seja, esta na gramatica).
            for (String production : grammar.get(symbol)) {
                //Para cada producao associada ao simbolo atual:
                String newSymbol = production + symbol.substring(1);
                //Substitui o simbolo atual pela producao, adicionando os simbolos restantes para processar.
                if (checkChain(grammar, newSymbol, chain, position)) {
                    //Chama recursivamente o metodo com o novo simbolo e a mesma posicao.
                    return true;
                    //Se uma das producoes for valida, retorna verdadeiro.
                }
            }
        } else {
            //Caso o simbolo atual seja terminal:
            if (chain.charAt(position) == symbol.charAt(0)) {
                //Verifica se o caractere da cadeia coincide com o terminal atual.
                return checkChain(grammar, symbol.substring(1), chain, position + 1);
                //Se coincidir, chama recursivamente com o proximo simbolo e incrementa a posicao.
            }
        }
        return false;
        //Se nenhuma producao for valida ou o terminal nao coincidir, retorna falso.
    }
    public static void main(String[] args) {
        //Metodo principal para testar o codigo.
        Map<String, List<String>> grammar = new HashMap<>();
        //Cria um mapa para armazenar a gramatica.
        grammar.put("S", List.of("aA", "bB", "c"));
        //Define as producoes para o simbolo inicial "S".
        //"S" pode produzir "aA", "bB" ou "c".
        grammar.put("A", List.of("aA", ""));
        //Define as producoes para o simbolo "A".
        //"A" pode produzir "aA" ou a cadeia vazia.
        grammar.put("B", List.of("bB", ""));
        //Define as producoes para o simbolo "B".
        //"B" pode produzir "bB" ou a cadeia vazia.
        System.out.println(belongsLanguage(grammar, "S", "aaa"));
        System.out.println(belongsLanguage(grammar, "S", "bbb"));
        System.out.println(belongsLanguage(grammar, "S", "aac"));
        System.out.println(belongsLanguage(grammar, "S", "c"));
    }
}


//Declaracao da classe publica chamada Q1.
public class Q1 {
    public static boolean belongsLanguage(String chain) {
        //Metodo publico e estatico que recebe uma cadeia de caracteres (chain) e retorna um booleano.
        //O objetivo e verificar se a cadeia pertence a uma linguagem especifica composta apenas por 'a' ou 'b'.
        if (chain.isEmpty()) {
            //Verifica se a string esta vazia.
            return false;
            //Se estiver vazia, retorna falso, ja que uma cadeia vazia nao pertence a linguagem.
        }
        if (chain.charAt(0) == 'a') {
            //Verifica se o primeiro caractere da cadeia e 'a'.
            return checkA(chain, 1);
            //Se for 'a', chama o metodo `checkA` para verificar o restante da cadeia.
        } else if (chain.charAt(0) == 'b') {
            //Caso contrario, verifica se o primeiro caractere da cadeia e 'b'.
            return checkB(chain, 1);
            //Se for 'b', chama o metodo `checkB` para verificar o restante da cadeia.
        } else {
            //Se o primeiro caractere nao for nem 'a' nem 'b'.
            return false;
            //Retorna falso, indicando que a cadeia nao pertence a linguagem.
        }
    }

    private static boolean checkA(String chain, int position) {
        //Metodo privado e estatico que verifica se a cadeia e composta apenas pelo caractere 'a'.
        //Recebe a cadeia e a posição atual a ser analisada.
        if (position >= chain.length()) {
            //Verifica se a posicao atual e igual ou maior que o comprimento da cadeia.
            return true;
            //Se for, significa que todos os caracteres analisados ate agora eram 'a', entao retorna verdadeiro.
        }
        if (chain.charAt(position) == 'a') {
            //Verifica se o caractere na posicao atual e 'a'.
            return checkA(chain, position + 1);
            //Se for, chama recursivamente o metodo `checkA` para analisar o proximo caractere.
        }
        return false;
        //Se o caractere atual nao for 'a', retorna falso, indicando que a cadeia nao e valida.
    }
    private static boolean checkB(String chain, int position) {
        //Metodo privado e estatico que verifica se a cadeia é composta apenas pelo caractere 'b'.
        //Recebe a cadeia e a posicao atual a ser analisada.
        if (position >= chain.length()) {
            //Verifica se a posição atual e igual ou maior que o comprimento da cadeia.
            return true;
            //Se for, significa que todos os caracteres analisados ate agora eram 'b', entao retorna verdadeiro.
        }
        if (chain.charAt(position) == 'b') {
            //Verifica se o caractere na posicao atual e 'b'.
            return checkB(chain, position + 1);
            //Se for, chama recursivamente o metodo `checkB` para analisar o proximo caractere.
        }
        return false;
        //Se o caractere atual nao for 'b', retorna falso, indicando que a cadeia nao e valida.
    }
    public static void main(String[] args) {
        //Metodo principal do programa. Aqui sao realizados os testes com diferentes cadeias de caracteres.
        System.out.println(belongsLanguage("aaa"));
        System.out.println(belongsLanguage("bbb"));
        System.out.println(belongsLanguage("aab"));
        System.out.println(belongsLanguage("bba"));
        System.out.println(belongsLanguage("a"));
        System.out.println(belongsLanguage("b"));
    }
}

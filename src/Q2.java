import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static List<String> generateChain(int N) {
        List<String> chains = new ArrayList<>();
        generateChainsRecursive("S", N, "", chains);
        return chains;
    }

    private static void generateChainsRecursive(String symbol, int N, String currentChain, List<String> chains) {

        if (currentChain.length() == N) {
            chains.add(currentChain);
            return;
        }


        switch (symbol) {
            case "S":

                generateChainsRecursive("A", N, currentChain + "a", chains);
                generateChainsRecursive("B", N, currentChain + "b", chains);

                if (currentChain.length() + 1 == N) {
                    chains.add(currentChain + "c");
                }
                break;

            case "A":

                generateChainsRecursive("A", N, currentChain + "a", chains);
                break;

            case "B":

                generateChainsRecursive("B", N, currentChain + "b", chains);
                break;
        }
    }

    public static void main(String[] args) {
        int N = 3;
        List<String> chains = generateChain(N);
        System.out.println("Cadeias de comprimento " + N + ": " + chains);
    }
}

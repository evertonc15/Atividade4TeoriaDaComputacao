import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

    public static boolean belongsLanguage(Map<String, List<String>> grammar, String initialSymbol, String chain) {
        return checkChain(grammar, initialSymbol, chain, 0);
    }

    private static boolean checkChain(Map<String, List<String>> grammar, String symbol, String chain, int position) {

        if (position == chain.length() && symbol.equals("")) {
            return true;
        }
        if (position == chain.length() || symbol.equals("")) {
            return false;
        }
        if (grammar.containsKey(symbol)) {
            for (String production : grammar.get(symbol)) {
                String newSymbol = production + symbol.substring(1);
                if (checkChain(grammar, newSymbol, chain, position)) {
                    return true;
                }
            }
        } else {
            if (chain.charAt(position) == symbol.charAt(0)) {
                return checkChain(grammar, symbol.substring(1), chain, position + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> grammar = new HashMap<>();
        grammar.put("S", List.of("aA", "bB", "c"));
        grammar.put("A", List.of("aA", ""));
        grammar.put("B", List.of("bB", ""));
        System.out.println(belongsLanguage(grammar, "S", "aaa"));
        System.out.println(belongsLanguage(grammar, "S", "bbb"));
        System.out.println(belongsLanguage(grammar, "S", "aac"));
        System.out.println(belongsLanguage(grammar, "S", "c"));
    }
}


public class Q1 {
    public static boolean belongsLanguage(String chain) {

        if (chain.isEmpty()) {
            return false;
        }
        if (chain.charAt(0) == 'a') {
            return checkA(chain, 1);
        } else if (chain.charAt(0) == 'b') {
            return checkB(chain, 1);
        } else {
            return false;
        }
    }


    private static boolean checkA(String chain, int position) {

        if (position >= chain.length()) {
            return true;
        }

        if (chain.charAt(position) == 'a') {
            return checkA(chain, position + 1);
        }

        return false;
    }


    private static boolean checkB(String chain, int position) {

        if (position >= chain.length()) {
            return true;
        }

        if (chain.charAt(position) == 'b') {
            return checkB(chain, position + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(belongsLanguage("aaa"));
        System.out.println(belongsLanguage("bbb"));
        System.out.println(belongsLanguage("aab"));
        System.out.println(belongsLanguage("bba"));
        System.out.println(belongsLanguage("a"));
        System.out.println(belongsLanguage("b"));
    }
}

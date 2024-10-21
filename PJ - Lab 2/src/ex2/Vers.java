package ex2;

public class Vers {

    static String nr_Vocale(String vers) {
        int nr_vocale = 0;
        String vers_lower = vers.toLowerCase();
        for (int i = 0; i < vers.length(); i++) {
            if (vers_lower.charAt(i) == 'a' || vers_lower.charAt(i) == 'e' || vers_lower.charAt(i) == 'i' ||
                    vers_lower.charAt(i) == 'o' || vers_lower.charAt(i) == 'u' || vers_lower.charAt(i) == 'y') {
                nr_vocale++;
            }
        }
        vers = vers + " | vocale: " + nr_vocale;
        return vers;
    }

    static String nr_Cuvinte(String vers) {
        int nr_cuvinte = -2;
        for (int i = 0; i < vers.length(); i++) {
            if (vers.charAt(i) == ' ' || vers.charAt(i) == '\'') {
                nr_cuvinte++;
            }
            else if (vers.charAt(i) == '*') {
                nr_cuvinte--;
            }
        }
        vers = vers + " cuvinte: " + nr_cuvinte;
        return vers;
    }

    static String steluta(String vers) {
            if (vers.endsWith("ve")) {
                vers = vers + " *";
            }
        return vers;
    }

    static String majuscule(String vers, float i) {
        if ( i < 0.1) {
            vers = vers.toUpperCase();
        }
        System.out.println(vers);
        return vers;
    }

}

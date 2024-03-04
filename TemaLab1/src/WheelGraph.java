public class WheelGraph {

    // Functia pentru generarea matricei de adiacenta a unui graf roata
    public static int[][] generareMatriceAdiacenta(int n) {
        int[][] matriceAdiacenta = new int[n][n];

        // Setarea conexiunilor centrului
        for (int i = 1; i < n; i++) {
            matriceAdiacenta[0][i] = 1;
            matriceAdiacenta[i][0] = 1;
        }

        // Setarea conexiunilor marginei
        for (int i = 1; i < n - 1; i++) {
            matriceAdiacenta[i][i+1] = 1;
            matriceAdiacenta[i+1][i] = 1;
        }
        matriceAdiacenta[1][n-1] = 1;
        matriceAdiacenta[n-1][1] = 1;

        return matriceAdiacenta;
    }

    // Functia pentru afisarea matricei de adiacenta
    public static void afisareMatriceAdiacenta(int[][] matriceAdiacenta) {
        for (int i = 0; i < matriceAdiacenta.length; i++) {
            for (int j = 0; j < matriceAdiacenta[0].length; j++) {
                System.out.print(matriceAdiacenta[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Functia pentru a numara ciclurile in graf
    public static int numaraCicluri(int n) {
        return (n * n) - (3 * n) + 3;
    }

    public static void main(String[] args) {
        int n = 5; // Numarul de varfuri in graf

        // Generare si afisare matrice de adiacenta
        int[][] matriceAdiacenta = generareMatriceAdiacenta(n);
        System.out.println("Matrice de Adiacenta:");
        afisareMatriceAdiacenta(matriceAdiacenta);

        // Numararea ciclurilor in graf
        int numarCicluri = numaraCicluri(n);
        System.out.println("Numarul de cicluri: " + numarCicluri);
    }
}

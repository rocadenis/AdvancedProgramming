package Lab1;
class KReductibleNumbers {

    private static boolean isKReductible(int num, int k) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            num = sum;
        }
        return num == k;
    }

public static void main(String[] args) {
    if (args.length != 3) {
        System.out.println("a b k");
        return;
    }

    int a, b, k;
    try {
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        k = Integer.parseInt(args[2]);
    } catch (NumberFormatException e) {
        System.out.println("Argumente invalide a, b si k.");
        return;
    }

    if (a > b) {
        System.out.println("Interval invalid. 'a'<='b'.");
        return;
    }


    if (k < 0) {
        System.out.println("Valoare invalida pentru k. 'k' pozitiv.");
        return;
    }

    StringBuilder result = new StringBuilder();
    for (int i = a; i <= b; i++) {
        if (isKReductible(i, k)) {
            result.append(i).append(" ");
        }
    }

    System.out.println("K-reductibile numere in intervalul [" + a + ", " + b + "]: " + result.toString());
}
}
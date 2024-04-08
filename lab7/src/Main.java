// Main.java
public class Main {
    public static void main(String[] args) {
        int numPlayers = 4;
        int n = 3;
        TokenBag bag = new TokenBag(n);

        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player("Player " + (i + 1), bag);
            new Thread(player).start();
        }
    }
}

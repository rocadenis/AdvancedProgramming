import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player implements Runnable {
    private String playerName;
    private List<Token> tokens = new ArrayList<>();
    private TokenBag bag;
    private static Lock bagLock = new ReentrantLock();
    private int maxSequenceValue = 0;

    public Player(String name, TokenBag bag) {
        this.playerName = name;
        this.bag = bag;
    }

    @Override
    public void run() {
        while (true) {
            Token token = extractToken();
            if (token == null) {
                break;
            }
            tokens.add(token);
            System.out.println(playerName + " extracted " + token);
            int sequenceValue = tokens.size();
            if (sequenceValue > maxSequenceValue) {
                maxSequenceValue = sequenceValue;
            }
        }
        System.out.println(playerName + " has extracted all tokens. Max sequence value: " + maxSequenceValue);
    }

    private Token extractToken() {
        bagLock.lock();
        try {
            return bag.pop();
        } finally {
            bagLock.unlock();
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getName() {
        return playerName;
    }
}

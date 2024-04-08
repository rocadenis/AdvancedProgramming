// TokenBag.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TokenBag {
    private List<Token> tokens = new ArrayList<>();

    public TokenBag(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.add(new Token(i, j));
                }
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token pop() {
        if (!tokens.isEmpty()) {
            return tokens.remove(tokens.size() - 1);
        }
        return null;
    }
}

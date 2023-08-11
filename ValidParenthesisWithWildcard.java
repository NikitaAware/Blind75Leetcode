import java.util.HashSet;

public class ValidParenthesisWithWildcard {
    String s;
    HashSet<String> vis;

    ValidParenthesisWithWildcard(String s) {
        this.s = s;
        this.vis = new HashSet<String>();
    }

    public void validParenthesisWithWildcard() {
        System.out.println(isValidParenthesis());
    }

    private boolean isValidParenthesis() {
        return isValidParenthesisHelper(0, 0);
    }

    private boolean isValidParenthesisHelper(int pos, int open) {
        if (pos == s.length()) {
            return open == 0;
        }
        if (open < 0) {
            return false;
        }
        String curr = pos + ":" + open;
        if (vis.contains(curr)) {
            return false;
        }
        vis.add(curr);
        if (s.charAt(pos) == ')') {
            if (open == 0) {
                return false;
            } else {
                return isValidParenthesisHelper(pos + 1, open - 1);
            }
        } else if (s.charAt(pos) == '(') {
            return isValidParenthesisHelper(pos + 1, open + 1);
        } else {
            // treat wild card as a open, close or empty
            return isValidParenthesisHelper(pos + 1, open - 1) || isValidParenthesisHelper(pos + 1, open + 1)
                    || isValidParenthesisHelper(pos + 1, open);
        }

    }
}
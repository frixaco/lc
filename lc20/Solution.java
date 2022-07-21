import java.util.HashMap;
import java.util.Stack;

class Solution2 {
    public static void main(String[] args) {
        Solution2 lc20Solution = new Solution2();

        String s = "()[]{}";
        boolean result = lc20Solution.isValid(s);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        var openStack = new Stack<Character>();

        var pairs = new HashMap<Character, Character>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (openStack.isEmpty() || openStack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                openStack.push(c);
            }
        }

        return openStack.isEmpty();
    }
}

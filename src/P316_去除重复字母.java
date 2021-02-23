import java.util.Stack;

public class P316_去除重复字母 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bacbc"));
    }
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] dict = new int[26];
        for(int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        boolean[] isExist = new boolean[26];

        for(char i : s.toCharArray()) {
            dict[i - 'a'] -= 1;
            if (isExist[i - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > i) {
                if (dict[stack.peek() - 'a'] == 0) {
                    break;
                }
                isExist[stack.pop() - 'a'] = false;
            }
            stack.push(i);
            isExist[i - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

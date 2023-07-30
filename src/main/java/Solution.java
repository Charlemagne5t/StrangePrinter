import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int strangePrinter(String s) {
        char[] sArray = s.toCharArray();
        char[] curArray = new char[s.length()];
        HashMap<String, Integer> memo =  new HashMap<>();
        return dfs(sArray, 0, curArray, memo);
    }

    private int dfs(char[] sArray, int i, char[] curArray, HashMap<String, Integer> memo) {
        if (Arrays.equals(sArray, curArray)) {
            return 0;
        }
        if (Arrays.equals(sArray, curArray) && i >= sArray.length) {
            return Integer.MAX_VALUE / 4;
        }
        if(memo.containsKey(i + " " + Arrays.toString(curArray))){
            return memo.get(i + " " + Arrays.toString(curArray));
        };

        int result = Integer.MAX_VALUE;
        if (curArray[i] == sArray[i]) {
            result = dfs(sArray, i + 1, curArray, memo);
        }
        for (int j = i; j < sArray.length; j++) {
            char[] chars = Arrays.copyOf(curArray, curArray.length);

            for (int k = i; k <= j; k++) {
                chars[k] = sArray[i];
            }
            result = Math.min(result, dfs(sArray, i + 1, chars, memo) + 1);
        }
        memo.put(i + " " + Arrays.toString(curArray), result);
        return result;
    }
}
import java.util.*;

public class LetterCombinations {
    List<String> res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return null;
        }
        backtracing(digits.toCharArray(),0,phoneMap);
        return res;
    }

    private void backtracing(char[] digits, int startindex,Map<Character, String> phoneMap) {
        if(startindex==digits.length){
            res.add(sb.toString());
            return;
        }
        String s = phoneMap.get(digits[startindex]);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracing(digits, startindex+1, phoneMap);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}

import java.util.Arrays;

public class AnagramChecker {
    private boolean result;
    private char[] firstChar;
    private char[] secondChar;
    private int looper;

    public boolean check(String first, String second) {
        result = false;

        //null value will return false

        if (first != null && second != null){

            first  = first.trim();
            second = second.trim();

        //blank value will return false

        if (first.length() != second.length() || first.length() == 0) {

            return false;

        } else {

            //ignoring uppercase or lowercase difference

            firstChar = first.toLowerCase().toCharArray();
            secondChar = second.toLowerCase().toCharArray();
            Arrays.sort(firstChar);
            Arrays.sort(secondChar);
            looper = 0;

            while (looper < firstChar.length) {
                if (firstChar[looper] == secondChar[looper]) {
                    if (looper == firstChar.length - 1) {
                        result = true;
                        break;
                    }
                    looper++;
                } else {
                    break;
                }
            }

            return result;
        }

      }else{
            return false;
        }
    }
}

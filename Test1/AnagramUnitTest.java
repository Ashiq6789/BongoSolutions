public class AnagramUnitTest {

    public static void main (String[] args){

        AnagramChecker anagramChecker = new AnagramChecker();

        String s1 = "table";
        String s2 = "ebatla";

        long time =System.nanoTime();

        boolean check =anagramChecker.check( s1, s2);

        time =System.nanoTime()-time;

        System.out.println("Input1: "+s1+"\nInput2: "+s2+"\nResult: "+check +"\nTime taken: "+time+ "ns");
    }
}

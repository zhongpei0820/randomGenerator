import java.util.HashSet;

/**
 * Created by zhongpei on 2016/10/16.
 */
public class Test {

    private final static int RANGE = 100000000;
    private final static int NUMBER_OF_ELEMENTS = 10000;


    public static void main(String args[]) {


        //Test the runtime of generating random numbers.
        Test.timeTest();


        //Test if the numbers are unique
        Test.uniqueTest();


        //Test runtime memory
        Test.memoryTest();
    }


    private static void timeTest() {

        numberGenerator nG = new numberGenerator();

        System.out.println("Testing runtime...");
        System.out.println("Generating " + NUMBER_OF_ELEMENTS + " random numbers from 0 to " + RANGE + " ...");

        long startTime = System.currentTimeMillis();
        nG.generateNoDup(RANGE, NUMBER_OF_ELEMENTS);
        long endTime = System.currentTimeMillis();

        System.out.print("The time is ");
        System.out.print(endTime - startTime);
        System.out.println("ms");
    }

    private static void uniqueTest() {
        numberGenerator nG = new numberGenerator();
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("Testing duplicates...");
        int[] random = nG.generateNoDup(RANGE, NUMBER_OF_ELEMENTS);
        boolean flag = true;
        for (int i = 0; i < random.length; i++) {
            if (!hashSet.add(random[i])) flag = false;
        }
        System.out.println("No duplicates :" + flag);
    }

    private static void memoryTest() {
        Runtime.getRuntime().gc();
        numberGenerator nG = new numberGenerator();
        nG.generateNoDup(RANGE, NUMBER_OF_ELEMENTS);
        System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024L * 1024L) + "MB");
        Runtime.getRuntime().gc();
    }
}

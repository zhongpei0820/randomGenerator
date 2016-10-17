import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhongpei on 2016/10/16.
 */
public class numberGenerator {
    Random random;

    public numberGenerator() {
        random = new Random();
    }


    //Generate k random numbers from 1 to n without duplicates.
    public int[] generateNoDup(int n, int k) {
        int[] array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            int index = random.nextInt(n + 1);
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
        return Arrays.copyOfRange(array, 0, k + 1);
    }
}

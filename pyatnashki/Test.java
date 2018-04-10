package panoramos.itschool.samsung.com.pyatnashki;

import java.util.Random;

/**
 * Created by Viktor on 04.04.2018.
 */

public class Test {
    public static void main(String[] args) {
        int i, j, arraySize = 16, randomSize = 16;
        Random newRandom = new Random();
        int[] array1 = new int[16];

        for (i = 0; i < array1.length; ) {
            int randomNumber = newRandom.nextInt(16);
            for (j = 0; j < i; j++) {
                if (array1[j] == randomNumber) {
                    break;
                }
            }
            if (j == i) {
                array1[i] = randomNumber;
                System.out.print(array1[i] + " ");
                i++;
            }
        }
    }

}


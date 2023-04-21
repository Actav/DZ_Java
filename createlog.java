/*
2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
*/

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class createlog {
    static Logger LOGGER;

    static {
        try {
            FileHandler fh = new FileHandler("./logger.log");
            fh.setFormatter(new SimpleFormatter());
            LOGGER = Logger.getLogger(Main.class.getName());
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] arrInt = new int[]{0, 1, 2, 9, 8, 7, 6, 5, 4, 3};
        boolean flag = true;

        for (int i = 0; flag && i < arrInt.length; i++) {
            LOGGER.log(Level.INFO, Arrays.toString(arrInt));

            flag = false;
            for (int j = 1; j < arrInt.length - i; j++) {
                if (arrInt[j - 1] > arrInt[j]) {
                    int tmp = arrInt[j];
                    arrInt[j] = arrInt[j - 1];
                    arrInt[j - 1] = tmp;

                    flag = true;
                }
            }
        }
    }
}

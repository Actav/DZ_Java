import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] inputArray = new int[100];

        arrayFill(inputArray);
        System.out.println(Arrays.toString(inputArray));

        mergeSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] tempArray = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            tempArray[k] = array[i];
            k++;
            i++;
        }

        while (j <= right) {
            tempArray[k] = array[j];
            k++;
            j++;
        }

        System.arraycopy(tempArray, 0, array, left, tempArray.length);
    }

    private static void arrayFill(int[] inputArray) {
        for (int i = inputArray.length, k = 0; i > 0; i--, k++) {
            inputArray[k] = i;
        }

    }
}

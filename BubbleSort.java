import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class BubbleSort {
        public static void main(String[] args) {
            int [] array = new int[] {4, 2, 1, 5, 3};
            int [] sortedOne = bubbleSort3(array);
            for (int i = 0; i < sortedOne.length; i++) {
              //  System.out.println(sortedOne[i] + " ");
            }
           // for (int n : array) {
            //    System.out.print(n + " ");
            //}
        }
        static int [] bubbleSort(int[] array) {
            boolean sorted = false;
            int temp;
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i+1]) {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                }
            }
            return array;
        }
        //Это алгоритм написанный по памяти
        static int [] bubbleSort2 (int[] array) {
            boolean sorted = false;
            int temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
            return array;
        }

        static int [] bubbleSort3 (int[] array){
            boolean sorted = false;
            int doomy, n = 1;
            while (!sorted){
                sorted = true;
                for (int i = 0; i < array.length - n; i++) {
                    if(array[i] > array[i + 1]){
                        doomy = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = doomy;
                        sorted = false;
                    }
                }
                n++;
            }
            return array;
        }

    }

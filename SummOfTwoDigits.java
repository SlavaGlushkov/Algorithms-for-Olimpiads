import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Дана задача. Массив данных и число. Нужно подобрать из массива два числа, такие что их сумма равнялась бы заданному числу.
//Примеры:
/*
[-1, 2, 5, 8] k = 7
[-3, -1, 0, 2, 6] k = 6
[2, 4, 5] k = 8
[-2, -1, 1, 2] k = 0
*/
public class SummOfTwoDigits {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println("Решение наивное, простым перебором " + Arrays.toString(sumOfPairEnumeration(array, k)));
        System.out.println("Решение HashSet " + Arrays.toString(sumOfPairHashSet(array, k)));
        System.out.println("Решение бинарный поиск, метод левой и правой границ " + Arrays.toString(sumOfPairBinSearch(array, k)));
        System.out.println("Решение два указателя " + Arrays.toString(sumOfPairsTwoMarks(array, k)));
    }

    //Решение перебором (время работы O(n^2), память O(1)) [-3, 0, 2 , 4, 5], k = 7
    static int[] sumOfPairEnumeration(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k)
                    return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    //Решение Hashset (время работы O(n), память O(n)) [-7, 0, 2 , 3, 6, 8, 10, 15, 18, 20], k = 10
    static int[] sumOfPairHashSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = k - nums[i];
            if (set.contains(numberToFind)) {
                return new int[]{numberToFind, nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[0];
    }

    //Решение Бинарный поиск (время работы O(n log n), память O(1)) [-5, -3, -2 , -1, 1, 4, 9, 11], k = 3
    //Работает только для отсортированных массивов
    static int[] sumOfPairBinSearch(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = k - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == numberToFind) {
                    return new int[]{nums[i], nums[mid]};
                }
                if (numberToFind < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return new int[0];
    }

    //Решение Два указателя (время работы O(n), память O(1))
    //Работает только для отсортированных массивов
    static int[] sumOfPairsTwoMarks(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                return new int[]{nums[l], nums[r]};
            }
            if (sum < k) {
                l++;
            }
            if (sum > k) {
                r--;
            }
        }
        return new int[0];
    }
}

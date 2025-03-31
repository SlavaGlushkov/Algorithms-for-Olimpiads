import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class InformaticsB {
    static int weights[];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int N = sc.nextInt();
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }
        int W = sc.nextInt();
        knapsack1(weights, W);
    }
    static void knapsack1(int[] weights, int W)
    {
        //Создаем матрицу в которую будем записывать номиналы
        String [][] nominals = new String [W + 1][];
        int[] dp = new int[W + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int w = 1; w <= W; w++)
        {
            for (int i = 0; i < weights.length; i++)
            {
                if (weights[i] <= w)
                {
                    //dp[w] = Math.min(dp[w], dp[w - wts[i]] + cost[i]);
                    if (dp[w] > dp[w - weights[i]] + 1){
                        if (nominals[w - weights[i]] == null){
                            nominals[w] = new String [1];
                            nominals[w][0] = String.valueOf(weights[i]);
                        }
                        else {
                            ArrayList<String> list = new ArrayList<>();
                            Collections.addAll(list, nominals[w - weights[i]]);
                            nominals[w] = new String[nominals[w - weights[i]].length + 1];
                            nominals[w][nominals[w].length - 1] = String.valueOf(weights[i]);
                            for (int j = 0; j < list.size(); j++) {
                                nominals[w][j] = list.get(j);
                            }
                        }
                        //int index0 = Arrays.binarySearch(nominals[w], 0);
                        //nominals[w].addLast(weights[i]);
                    }
                    dp[w] = Math.min(dp[w], dp[w - weights[i]] + 1);
                }
            }
        }
        for (int i = 0; i < nominals[W].length; i++) {
            System.out.print(nominals[W][i] + " ");
        }
    }
}
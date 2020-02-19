package com.rdruzhchenko;

import java.util.ArrayList;

public class PizzaCalculator {

    Integer[] array;

    public OutputData calculate(InputData inputData) {

        OutputData outputData = new OutputData();
        array = inputData.slices;
        var needed = inputData.maxSlices;

        int n = array.length;
        int dp[][] = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (array[j - 1] <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - array[j - 1]][j - 1] + array[j - 1]);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }

        ArrayList<Integer> list = new ArrayList();
        var res = dp[needed][n];
        System.out.println(res);
        System.out.println();
        for (int i = n; i > 0 && res > 0 ; i--) {
            if (res != dp[needed][i-1]) {
                list.add(i-1);
                res = res - array[i-1];
                needed = needed - array[i-1];
            }
        }

        outputData.pizzasIndexes = (Integer[])list.toArray(new Integer[list.size()]);
        return outputData;
    }
}

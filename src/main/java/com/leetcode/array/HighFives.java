package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class HighFives {

    // 1086. High Five
    /*
    Given a list of scores of different students
    return the average score of each students
    top 5 scores

    in the order of each students id

    List of scores
    Each entry items[i]
    has items[i][0] the students id,
    and items[i][1] the students score.

    The average score is calculated using
    integer division.

    Example 1:

    Input:
    [[1,91],[1,92],
    [2,93],[2,97],
    [1,60],
    [2,77],
    [1,65],
    [1,87],
    [1,100],
    [2,100],
    [2,76]]

    Output: [[1,87],[2,88]]
    Explanation:
    The average of the student with id = 1 is 87.
    The average of the student with id = 2 is 88.6.


    But with integer division their average converts to 88.
     */


    public static void main(String...args){
        int[][] items = {
                {1,91},
                {1,92},
                {2,93},
                {2,97},
                {1,60},
                {2,77},
                {1,65},
                {1,87},
                {1,100},
                {2,100},
                {2,76}
        };

        var result = highfive(items);

    }

    public static int[][] highfive(int[][] items){

        final Comparator<int[]> studentComparator = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };

        final Comparator<int[]> gradeComparator = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        };

        Map<Integer,Integer> cache = new HashMap<>();
        Arrays
                .sort(items,studentComparator.thenComparing(gradeComparator).reversed());
        Arrays.stream(items)
                .collect(groupingBy(i -> i[0]))
                .forEach((k,v) -> {
                    int value = (int)v
                            .stream()
                            .limit(5)
                            .mapToInt(ints -> ints[1])
                            .average()
                            .orElse(0);
                    cache.put(k,value);
                });

        int[][] result = new int[cache.size()][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : cache.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;

    }

}

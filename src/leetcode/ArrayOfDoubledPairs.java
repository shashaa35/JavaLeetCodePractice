package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/array-of-doubled-pairs/
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> mapFrequency = new HashMap<>();
        for (int e: arr)
            mapFrequency.put(e, mapFrequency.getOrDefault(e,0) + 1);

        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < B.length; i++)
            B[i] = arr[i];

        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int i = 0; i < B.length; i++) {
            if (mapFrequency.get(B[i]) == 0)
                continue;
            if (mapFrequency.getOrDefault(2*B[i], 0) == 0)
                return false;
            mapFrequency.put(B[i], mapFrequency.get(B[i]) - 1);
            mapFrequency.put(2*B[i], mapFrequency.get(2*B[i]) - 1);
        }

        return true;
    }
}

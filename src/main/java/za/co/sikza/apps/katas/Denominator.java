package za.co.sikza.apps.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Denominator {
    public int solution(int[] array) {
        var max = new AtomicInteger(0);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            var number = array[i];
            var counter = countApearanceForNumber(number, array);
            map.putIfAbsent(number, counter);
            max.set(Math.max(max.get(), counter));
        }
        List<Map.Entry<Integer, Integer>> denominators = map.entrySet().stream().filter(e -> e.getValue() == max.get()).collect(Collectors.toList());
        var maxNum = denominators.get(0);
        if (denominators.size() > 1) return -1;

        return maxNum.getValue() > (array.length / 2) ? findIndex(maxNum.getKey(), array) : -1;
    }

    private int findIndex(Integer key, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) return i;
        }
        throw new IllegalArgumentException();
    }

    private int countApearanceForNumber(int number, int[] array) {
        return (int) Arrays.stream(array).filter(n -> n == number).count();
    }
}

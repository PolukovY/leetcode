package com.levik.leetcode.taskAssignment;

import java.util.*;

public class Program {

    public List<List<Integer>> taskAssignment(int k, List<Integer> tasks) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupItems = groupItems(tasks);
        Collections.sort(tasks);

        for (int idx = 0; idx < k; idx++) {
            Integer fist = tasks.get(idx);
            Integer last = tasks.get(tasks.size() - 1 - idx);

            List<Integer> fistIndex = groupItems.get(fist);
            List<Integer> lastIndex = groupItems.get(last);
            Integer takeFist = fistIndex.remove(fistIndex.size() - 1);
            Integer takeLast = lastIndex.remove(lastIndex.size() - 1);

            result.add(Arrays.asList(takeFist, takeLast));
        }

        return result;
    }

    private Map<Integer, List<Integer>> groupItems(List<Integer> tasks) {
        Map<Integer, List<Integer>> groupItems = new HashMap<>();

        for (int index = 0; index < tasks.size(); index++) {
            Integer task = tasks.get(index);
            List<Integer> indexes = groupItems.getOrDefault(task, new ArrayList<>());
            indexes.add(index);
            groupItems.put(task, indexes);
        }

        return groupItems;
    }
}

package com.levik.leetcode.classPhotos;

import java.util.Collections;
import java.util.List;

public class Program {

    public boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        boolean isRedFirst = redShirtHeights.get(redShirtHeights.size() - 1) >= blueShirtHeights.get(blueShirtHeights.size() - 1);
        boolean result = true;

        for (int i = redShirtHeights.size() - 1; i >= 0; i--) {
            int red = redShirtHeights.get(i);
            int blue = blueShirtHeights.get(i);

            if (isRedFirst) {
                if (red <= blue) {
                    result = false;
                }
            } else {
                if (blue <= red) {
                    result = false;
                }
            }
        }

        return result;
    }
}

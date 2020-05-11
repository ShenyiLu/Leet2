package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L403FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        if (stones.length == 1) {
            return true;
        }

        // can only attempt to jump to first stone
        if (stones[1] != 1) {
            return false;
        }

        int lastIndex = stones.length - 1;
        long lastPosition = stones[lastIndex];

        if (lastIndex == 1 && lastPosition == 1) {
            return true;
        }

        HashMap<Long, HashSet<Long>> stepMap = new HashMap<>();
        for (int position : stones) {
            stepMap.put((long) position, new HashSet<>());
        }
        stepMap.get((long)1).add((long) 1);

        long index = 1;
        while (index < stones.length - 1) {
            long currPosition = stones[(int) index];
            HashSet<Long> lastJumps = stepMap.get(currPosition);
            for (long k : lastJumps) {
                for (long nextJump = Math.max(k - 1, 1); nextJump <= k + 1; nextJump++) {
                    long destPosition = currPosition + nextJump;
                    if (destPosition == lastPosition) {
                        return true;
                    }
                    if (destPosition < lastPosition && stepMap.containsKey(destPosition)) {
                        stepMap.get(destPosition).add(nextJump);
                    }
                }
            }
            stepMap.remove(currPosition);
            index++;
        }
        return false;
    }
}

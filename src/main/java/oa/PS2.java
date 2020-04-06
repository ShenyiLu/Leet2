package oa;

import java.util.List;
import java.util.Stack;

public class PS2 {
    // Complete the check_log_history function below.
    static int check_log_history(List<String> events) {
        boolean[] state = new boolean[1000001];
        for (int i = 0; i < state.length; i++) {
            state[i] = false;
        }
        Stack<Integer> acquiredStack = new Stack<>();

        for (int eventIndex = 0; eventIndex < events.size(); eventIndex++) {
            int eventNumber = eventIndex + 1;
            String event = events.get(eventIndex);
            if (event.startsWith("ACQUIRE ")) {
                int x = Integer.parseInt(event.replace("ACQUIRE ", ""));

                // attempt to re-acquire lock
                if (state[x]) {
                    return eventNumber;
                }
                acquiredStack.add(x);
                state[x] = true;
            } else {
                int x = Integer.parseInt(event.replace("RELEASE ", ""));
                // attempt to re-release lock
                if (!state[x]) {
                    return eventNumber;
                }

                // violate sequence
                if (x != acquiredStack.peek()) {
                    return eventNumber;
                }

                acquiredStack.pop();
                state[x] = false;
            }
        }

        if (acquiredStack.size() == 0) {
            return 0;
        }
        return events.size() + 1;
    }

}

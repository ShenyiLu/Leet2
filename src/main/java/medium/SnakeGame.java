package medium;

import java.util.*;

public class SnakeGame {
    private int width;
    private int height;
    private List<List<Integer>> foods;
    private int foodsIndex;
    private HashSet<List<Integer>> bodyPosition;
    private Queue<List<Integer>> trail;
    private HashMap<String, int[]> directions;
    private List<Integer> currentLocation;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foods = new ArrayList<>();
        for (int[] f : food) {
            List<Integer> temp = new ArrayList<>();
            for (int i : f) {
                temp.add(i);
            }
            foods.add(temp);
        }
        foodsIndex = 0;
        bodyPosition = new HashSet<>();
        trail = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        bodyPosition.add(start);
        trail.offer(start);
        currentLocation = start;

        directions = new HashMap<>();
        directions.put("U", new int[]{-1, 0});
        directions.put("L", new int[]{0, -1});
        directions.put("R", new int[]{0, 1});
        directions.put("D", new int[]{1, 0});
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] nextStep = directions.get(direction);
        List<Integer> nextLocaion = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            nextLocaion.add(currentLocation.get(i) + nextStep[i]);
        }

        currentLocation = nextLocaion;

        int size = trail.size() - 1;
        if (foodsIndex < foods.size() && foods.get(foodsIndex).equals(currentLocation)) {
            foodsIndex++;
            size++;
        } else {
            bodyPosition.remove(trail.poll());
        }
        if (!isValidMove(nextLocaion)) {
            return -1;
        }
        trail.offer(currentLocation);
        bodyPosition.add(currentLocation);
        return size;
    }

    private boolean isValidMove(List<Integer> nextLocation) {
        if (nextLocation.get(1) < 0 || nextLocation.get(1) >= width || nextLocation.get(0) < 0 || nextLocation.get(0) >= height) {
            return false;
        }

        if (trail.contains(nextLocation)) {
            System.out.println("next: " + nextLocation);
            return false;
        }
        return true;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */


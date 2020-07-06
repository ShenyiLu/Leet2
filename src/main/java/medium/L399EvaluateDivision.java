package medium;

import java.util.*;

public class L399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<HashMap<String, Double>> stringValuesList = new ArrayList<>();
        HashSet<String> needValues = new HashSet<>();
        for (List<String> equation : equations) {
            needValues.addAll(equation);
        }
        for (List<String> equation : equations) {
            needValues.remove(equation.get(1));
        }

        HashMap<String, HashMap<String, Double>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            equationMap.putIfAbsent(equation.get(0), new HashMap<>());
            equationMap.get(equation.get(0)).put(equation.get(1), values[i]);
            // need reverse here
            equationMap.putIfAbsent(equation.get(1), new HashMap<>());
            equationMap.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }
        Queue<String> calculateValues = new LinkedList<>();
        while (!needValues.isEmpty()) {
            String nextValue = needValues.iterator().next();

            HashMap<String, Double> stringValues = new HashMap<>();
            stringValues.put(nextValue, 1.0);
            needValues.remove(nextValue);
            calculateValues.add(nextValue);
            while (!calculateValues.isEmpty()) {
                int size = calculateValues.size();
                while (size-- > 0) {
                    String known = calculateValues.poll();
                    double knownValue = stringValues.get(known);
                    for (Map.Entry<String, Double> entry : equationMap.get(known).entrySet()) {
                        String unknown = entry.getKey();
                        if (stringValues.containsKey(unknown)) {
                            continue;
                        }
                        double unknownValue = knownValue / entry.getValue();
                        stringValues.put(unknown, unknownValue);
                        calculateValues.add(unknown);
                        needValues.remove(unknown);
                    }
                }
            }
            stringValuesList.add(stringValues);
        }

        // calculate result
        double[] result = new double[queries.size()];
        int resultIndex = 0;
        for (List<String> query : queries) {
            String numerator = query.get(0);
            String denominator = query.get(1);
            result[resultIndex] = -1;
            for (HashMap<String, Double> stringValues : stringValuesList) {
                if (stringValues.containsKey(numerator) && stringValues.containsKey(denominator)) {
                    result[resultIndex] = stringValues.get(numerator) / stringValues.get(denominator);
                    break;
                }
            }
            resultIndex++;
        }
        return result;
    }
}

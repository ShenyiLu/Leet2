package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L811SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visitCountMap = new HashMap<>();
        for (String record : cpdomains) {
            // break cpdomain into visit count and domain
            String[] breakRecord = record.split(" ");
            int visitCount = Integer.parseInt(breakRecord[0]);

            // break domain into levels
            String[] subDomains = breakRecord[1].split("\\.");
            String currentDomain = "";
            boolean first = true;

            // rebuild levels into sub-domain, add all sub domains and their count into map
            for (int i = subDomains.length - 1; i >= 0; i--) {
                if (first) {
                    currentDomain = subDomains[i] + currentDomain;
                    first = false;
                } else {
                    currentDomain = subDomains[i] + "." + currentDomain;
                }
                visitCountMap.putIfAbsent(currentDomain, 0);
                visitCountMap.put(currentDomain, visitCount + visitCountMap.get(currentDomain));
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : visitCountMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}

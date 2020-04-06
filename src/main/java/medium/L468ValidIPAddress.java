package medium;

public class L468ValidIPAddress {
    public String validIPAddress(String IP) {
        if (IP.startsWith(".") || IP.startsWith(":") || IP.endsWith(".") || IP.endsWith(":")) {
            return "Neither";
        }

        if (IP.contains(".") || IP.contains(":")) {
            if (IP.contains(".") && !IP.contains(":") && validIPV4(IP)) {
                return "IPV4";
            }
            if (!IP.contains(".") && IP.contains(":") && validIPV6(IP)) {
                return "IPV6";
            }
        }
        return "Neither";
    }

    private boolean validIPV4(String IP) {
        String[] groups = IP.split("\\.");
        if (groups.length != 4) {
            return false;
        }
        for (String str : groups) {
            int index = 0;
            while (index < str.length()) {
                char c = str.charAt(index);
                if ((c < '0' || c > '9')) {
                    return false;
                }
                index++;
            }


            if (!str.equals("0") && str.startsWith("0")) {
                return false;
            }
            try {
                int val = Integer.parseInt(str);
                if (val < 0 || val > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPV6(String IP) {
        String[] groups = IP.split(":");
        if (groups.length != 8) {
            return false;
        }
        for (String str : groups) {
            if (str.length() == 0 || str.length() > 4) {
                return false;
            }
            int index = 0;
            while (index < str.length()) {
                char c = str.charAt(index);
                if ((c < 'A' || c > 'F') && (c < 'a' || c > 'f') && (c < '0' || c > '9')) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}

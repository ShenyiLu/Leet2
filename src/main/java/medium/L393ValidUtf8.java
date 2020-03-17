package medium;

public class L393ValidUtf8 {
    public boolean validUtf8(int[] data) {
        String[] binary = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            binary[i] = Integer.toBinaryString(data[i]);
            while (binary[i].length() < 8) {
                binary[i] = "0" + binary[i];
            }
        }

//        for (String s: binary) {
//            System.out.println(s);
//        }

        int index = 0;
        while (index < data.length) {
            if (binary[index].length() != 8) {
                return false;
            }
            if (binary[index].startsWith("0")) {
                index++;
                continue;
            }
            if (binary[index].startsWith("110")) {
                if (index + 1 >= data.length) {
                    return false;
                }
                if (!check(binary, index, 1)) {
                    return false;
                }
                index += 2;
                continue;
            }
            if (binary[index].startsWith("1110")) {
                if (index + 2 >= data.length) {
                    return false;
                }
                if (!check(binary, index, 2)) {
                    return false;
                }
                index += 3;
                continue;
            }
            if (binary[index].startsWith("11110")) {
                if (index + 3 >= data.length) {
                    return false;
                }
                if (!check(binary, index, 3)) {
                    return false;
                }
                index += 4;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean check(String[] binary, int i, int size) {
        for (int k = 1; k <= size; k++) {
            if (binary[i + k].length() != 8 || !binary[i + k].startsWith("10")) {
                return false;
            }
        }
        return true;
    }


}

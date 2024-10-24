package com.pogodin;

public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        // stripped number
        StringBuilder sb = number.chars()
                .filter(n -> n >= '0' && n <= '9')
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        int localCounter = 0;
        for (int i = 0; i < sb.length(); i++) {
            int left = sb.length() - i - 1;
            localCounter++;
            if (localCounter == 3 && left >= 2) {
                // inserting at i+1 and moving one forward at the same time
                sb.insert(++i, '-');
                localCounter = 0;
            }
        }

        if (localCounter == 4) {
            sb.insert(sb.length() - 2, '-');
        }

        return sb.toString();
    }
}

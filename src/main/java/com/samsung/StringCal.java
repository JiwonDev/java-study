package com.samsung;

public final class StringCal {

    int add(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        if (str.contains("+")) {
            String[] nums = str.split("\\+");

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += Integer.parseInt(nums[i]);
            }
            return sum;
        }
        return Integer.parseInt(str);
    }
}

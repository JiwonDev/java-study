package com.samsung;

public final class StringCal {

    public int add(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        if (str.contains("+")) {
            String[] nums = str.split("\\+");
            return sum(nums);
        } else {
            return 0;
        }
    }

    public int sum(String[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Integer.parseInt(nums[i]);
        }
        return result;
    }


}

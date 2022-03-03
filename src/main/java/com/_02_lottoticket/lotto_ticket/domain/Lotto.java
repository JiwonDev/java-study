package com._02_lottoticket.lotto_ticket.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class Lotto {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto create(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> nums = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        isValid(nums);
        return new Lotto(nums);
    }

    public static Lotto create(List<Integer> numbers) {
        isValid(numbers);
        return new Lotto(numbers);
    }

    private static void isValid(List<Integer> nums) {
        Set<Integer> set = Set.copyOf(nums);
        if (set.size() != nums.size()) {
            throw new IllegalArgumentException();
        }
        boolean isLimit = nums.stream().anyMatch(item -> item <= MIN_NUMBER || item >= MAX_NUMBER);
        if(isLimit){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}

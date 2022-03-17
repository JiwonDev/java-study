package com._02_lottoticket.lotto_ticket.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private Integer bonus;

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

    public static Lotto create(String input, Integer bonus) {
        Lotto lotto = Lotto.create(input);
        lotto.setBonus(bonus);
        return lotto;
    }

    public static Lotto create(List<Integer> numbers) {
        isValid(numbers);
        return new Lotto(numbers);
    }

    private static void isValid(List<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = Set.copyOf(nums);
        if (set.size() != nums.size()) {
            throw new IllegalArgumentException();
        }

        boolean isLimit = nums.stream().anyMatch(item -> item < MIN_NUMBER || item > MAX_NUMBER);
        if (isLimit) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(List<Integer> numbers, Integer bonus) {
        boolean checkDuplicated = numbers.stream().anyMatch(num -> num.equals(bonus));
        if (checkDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Integer getSameNumberCount(Lotto lotto) {
        var lottoNumbers = lotto.getNumbers();
        int count = 0;
        for (Integer number : this.getNumbers()) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isCorrectBonusNumber(Lotto lotto) {
        return Objects.equals(this.bonus, lotto.getBonus());
    }

    private Integer getBonus() {
        return this.bonus;
    }

    public void setBonus(Integer bonus) {
        if (this.bonus != null) {
            throw new IllegalArgumentException();
        }
        isDuplicated(this.numbers, bonus);
        this.bonus = bonus;
    }

}

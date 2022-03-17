package com._02_lottoticket.lotto_ticket.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class LottoGeneratingStrategyImpl implements LottoGeneratingStrategy{

    private final Random random =  new Random();

    @Override
    public Lotto generateLotto() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 7) {
            int i = random.nextInt(45) + 1;
            set.add(i);
        }

        List<Integer> numbers = set.stream().toList();
        Lotto lotto = Lotto.create(numbers.subList(0, 6));
        lotto.setBonus(numbers.get(7));
        return lotto;
    }
}

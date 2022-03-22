package com._02_lottoticket.lotto_ticket.service;

import com._02_lottoticket.lotto_ticket.domain.Lotto;
import com._02_lottoticket.lotto_ticket.domain.LottoGeneratingStrategy;
import com._02_lottoticket.lotto_ticket.domain.Result;
import java.util.List;

public final class LottoService {

    private final Lotto winningLotto;
    private final LottoGeneratingStrategy lottoGeneratingStrategy;

    public LottoService(LottoGeneratingStrategy lottoGeneratingStrategy) {
        this.lottoGeneratingStrategy = lottoGeneratingStrategy;
        this.winningLotto = lottoGeneratingStrategy.generateLotto();
    }

    public List<Result> tryLottery(List<Lotto> lottos) {
        return lottos.stream()
            .map(this::tryLottery)
            .toList();
    }

    public Result tryLottery(Lotto lotto) {
        return new Result(lotto, getRank(lotto));
    }

    private int getRank(Lotto lotto) {
        Integer sameNumberCount = winningLotto.getSameNumberCount(lotto);
        boolean correctBonusNumber = winningLotto.isCorrectBonusNumber(lotto);
        int rank;
        switch (sameNumberCount) {
            case 6 -> rank = 1;
            case 5 -> {
                if (correctBonusNumber) {rank = 2;} else {rank = 3;}
            }
            case 4 -> rank = 4;
            case 3 -> rank = 5;
            default -> rank = 0;
        }
        return rank;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}

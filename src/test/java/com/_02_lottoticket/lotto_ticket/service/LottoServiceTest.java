package com._02_lottoticket.lotto_ticket.service;

import static org.assertj.core.api.Assertions.assertThat;

import com._02_lottoticket.lotto_ticket.domain.Lotto;
import com._02_lottoticket.lotto_ticket.domain.LottoGeneratingStrategy;
import com._02_lottoticket.lotto_ticket.domain.Result;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("로또 당첨 번호를 맞춘 경우, Result 에 1등을 반환한다. ")
    void test1() throws Exception {
        var lottoGeneratingStrategy = new StubGeneratingStrategy();
        LottoService service = new LottoService(lottoGeneratingStrategy);
        Lotto winning = lottoGeneratingStrategy.generateLotto();

        Result result = service.tryLottery(winning);

        assertThat(result.getRank()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 여러 개를 시도 하는 경우, 개수에 맞는 결과가 반환된다.")
    void test2() throws Exception {
        var lottoGeneratingStrategy = new StubGeneratingStrategy();
        LottoService service = new LottoService(lottoGeneratingStrategy);
        List<Lotto> lottos = List.of(
            Lotto.create("1,2,3,4,5,6", 7),
            Lotto.create("1,2,3,4,5,8", 7),
            Lotto.create("45,42,41,38,10,20", 11),
            Lotto.create("5,7,2,4,3,6", 8)
        );

        List<Result> result = service.tryLottery(lottos);

        assertThat(result.size()).isEqualTo(lottos.size());
    }

    static class StubGeneratingStrategy implements LottoGeneratingStrategy {

        private Lotto lotto;

        @Override
        public Lotto generateLotto() {
            Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
            lotto.setBonus(7);
            this.lotto = lotto;
            return lotto;
        }
    }
}

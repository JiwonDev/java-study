package com._02_lottoticket;

import com._02_lottoticket.lotto_ticket.controller.LottoController;
import com._02_lottoticket.lotto_ticket.domain.LottoGeneratingStrategyImpl;
import com._02_lottoticket.lotto_ticket.service.LottoService;
import com._02_lottoticket.lotto_ticket.view.LottoResponseDto;
import com._02_lottoticket.lotto_ticket.view.LottoView;

public final class Application {

    public static void main(String[] args) {
        // 객체를 만들고, 서비스 초기화 작업을 한다.
        var lottoService = new LottoService(new LottoGeneratingStrategyImpl());
        var controller = new LottoController(lottoService);

        // view 에서 입력을 받는다.
        var view = new LottoView();

        // 게임을 실행한다.
        LottoResponseDto lottoResponseDto = controller.startGame(view.getInput());

        // view 에서 결과를 출력을 한다.
        view.printOutput(lottoResponseDto);
    }
}

package com._02_lottoticket.lotto_ticket.controller;

import com._02_lottoticket.lotto_ticket.domain.Lotto;
import com._02_lottoticket.lotto_ticket.service.LottoService;
import com._02_lottoticket.lotto_ticket.view.LottoRequestDto;
import com._02_lottoticket.lotto_ticket.view.LottoResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.parser.Entity;

public final class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoResponseDto startGame(LottoRequestDto request) {
        var lotto = Lotto.create(request.getLotto(), request.getBonusNumber());
        var result = lottoService.tryLottery(lotto);
        var winningLotto = lottoService.getWinningLotto();

        return LottoResponseDto.builder()
            .lotto(lotto.toResultString())
            .rank(result.getRank())
            .winningNumber(winningLotto.toResultString())
            .build();
    }

    public List<LottoResponseDto> startGame(List<LottoRequestDto> RequestDtos) {
        List<LottoResponseDto> responseDtos = new ArrayList<>();
        for (LottoRequestDto lottoRequestDto : RequestDtos) {
            responseDtos.add(startGame(lottoRequestDto));
        }
        return responseDtos;
    }
}


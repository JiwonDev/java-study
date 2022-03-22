package com._02_lottoticket.lotto_ticket.view;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class LottoResponseDto {

    private Integer rank;
    private String lotto;
    private String winningNumber;

    @Builder
    public LottoResponseDto(Integer rank, String lotto, String winningNumber) {
        this.rank = rank;
        this.lotto = lotto;
        this.winningNumber = winningNumber;
    }
}

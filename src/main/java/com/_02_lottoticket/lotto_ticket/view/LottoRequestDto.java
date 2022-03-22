package com._02_lottoticket.lotto_ticket.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class LottoRequestDto {

    private String lotto;
    private Integer bonusNumber;

    public LottoRequestDto() {
    }

    public LottoRequestDto(String lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}

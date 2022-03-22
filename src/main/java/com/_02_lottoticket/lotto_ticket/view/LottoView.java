package com._02_lottoticket.lotto_ticket.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class LottoView {

    private final Scanner scanner = new Scanner(System.in);

    public LottoRequestDto getInput() {
        System.out.print("로또 번호를 입력하세요");
        var lottoNumber = scanner.next();
        System.out.print("보너스 번호를 입력 하세요");
        var bonusNumber = scanner.nextInt();

        // #TODO 금액을 줘야할까요? (금액을 계산하는건, 서비스 영역일지도?)
        return new LottoRequestDto(lottoNumber, bonusNumber);
    }

    public List<LottoRequestDto> inputRequestList() {
        List<LottoRequestDto> lottoRequestDtos = new ArrayList<>();
        System.out.println("얼마를 내시겠습니까 ?");
        int money = scanner.nextInt();
        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            lottoRequestDtos.add(getInput());
        }
        return lottoRequestDtos;
    }

    public void printOutput(LottoResponseDto lottoResponseDto) {
        System.out.println("당신의 번호는" + lottoResponseDto.getLotto());
        System.out.println("당첨 번호는" + lottoResponseDto.getWinningNumber());
        if (lottoResponseDto.getRank() == 0) {
            System.out.println("꽝입니다!");
        } else {
            System.out.println("당신의 등수는" + lottoResponseDto.getRank() + "등입니다");
        }
    }
}

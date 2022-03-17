package com._02_lottoticket.lotto_ticket.domain;

public final class Result {

    private final Lotto lotto;
    private final Integer rank;

    public Result(Lotto lotto, int rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Result{" +
            "lotto=" + lotto +
            ", rank=" + rank +
            '}';
    }
}

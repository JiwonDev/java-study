package com._03_chess.domain;

import java.util.UUID;
import lombok.Getter;

@Getter
public final class Player {

    private final String id;

    private Player(String id) {
        this.id = id;
    }

    public static Player of() {
        return new Player(getUniqueId());
    }

    private static String getUniqueId() {
        return UUID.randomUUID().toString().substring(10);
    }
}

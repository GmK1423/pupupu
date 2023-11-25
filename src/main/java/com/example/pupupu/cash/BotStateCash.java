package com.example.pupupu.cash;

import com.example.pupupu.tgBot.BotState;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@Setter
@Getter
//Used to save state bot.
public class BotStateCash {//Cache
    private final Map<Long, BotState> botStateMap = new HashMap<>();

    public void saveBotState(long userId, BotState botState) {
        botStateMap.put(userId, botState);
    }
}

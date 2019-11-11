package de.bot;

import com.rivescript.Config;
import com.rivescript.RiveScript;
import de.bot.subroutines.BotDateHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Component
public class ChatBot {

    private RiveScript bot;

    public ChatBot() {
        bot = new RiveScript(Config.utf8());
        try {
            bot.loadDirectory(getRivescriptDir());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bot.setSubroutine("botDateHandler", new BotDateHandler());
        bot.sortReplies();
    }

    private String getRivescriptDir() throws FileNotFoundException {
        return ResourceUtils.getFile("rivescript").getPath();
    }

    public String getReply(String msg) {
        return bot.reply("user", msg);
    }
}

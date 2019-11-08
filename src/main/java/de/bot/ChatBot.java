package de.bot;

import com.rivescript.Config;
import com.rivescript.RiveScript;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

public class ChatBot {

    private RiveScript riveScript;

    public ChatBot() {
        riveScript = new RiveScript(Config.utf8());
        try {
            riveScript.loadDirectory(getRivescriptDir());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        riveScript.sortReplies();
    }

    private String getRivescriptDir() throws FileNotFoundException {
        return ResourceUtils.getFile("rivescript").getPath();
    }


    public String getReply(String msg) {
        return riveScript.reply("user", msg);
    }
}

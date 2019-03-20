package de.bot;

import com.rivescript.Config;
import com.rivescript.RiveScript;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class ChatBot {

    private RiveScript bot;

    public ChatBot() {
        bot = new RiveScript(Config.utf8());
        try {
            bot.loadDirectory(getRivescriptDir());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bot.sortReplies();
    }

    private String getRivescriptDir() throws FileNotFoundException {
        return ResourceUtils.getFile("rivescript").getPath();
    }


    public String getReply(String msg) {
        return bot.reply("user", msg);
    }
}

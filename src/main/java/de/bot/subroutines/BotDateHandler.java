package de.bot.subroutines;

import com.rivescript.RiveScript;
import com.rivescript.macro.Subroutine;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BotDateHandler implements Subroutine {

    @Override
    public String call(RiveScript rs, String[] args) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dateFormatted = df.format(new Date());
        return dateFormatted;
    }
}

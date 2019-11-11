package de.bot;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ChatBotTest {

    private ChatBot cb = new ChatBot();


    @Test
    public void sayHelloBot() {
        String reply = cb.getReply("Hello Bot");
        assertThat(reply, is("Hello human."));
    }

    @Test
    public void sayHowAreYouBot() {
        String reply = cb.getReply("How are you");
        assertThat(reply, is("I'm fine. Thank you."));
    }

    @Test
    public void sayHowAreYouBotLowerCase() {
        String reply = cb.getReply("how are you");
        assertThat(reply, is("I'm fine. Thank you."));
    }

    @Test void sayWhoIsYourCreator() {
        String reply = cb.getReply("Who is your creator?");
        assertThat(reply, is("I was brought into life by FredAlex."));
    }

    @Test void canYouHelpMe() {
        String reply = cb.getReply("Can you help me?");
        assertThat(reply, is("With what exactly can I help you?"));
    }

    @Test void iNeedHelp() {
        String reply = cb.getReply("I need help");
        assertThat(reply, is("With what exactly can I help you?"));
    }

    @Test void myNameIs() {
        String reply = cb.getReply("Hello, my name is Alex");
        assertThat(reply, is("Nice to meet you, Alex."));
    }

    @Test void whatDateIsIt() {
        String reply = cb.getReply("What date is it?");
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String dateFormatted = df.format(new Date());
        assertThat(reply, is("Today is " + dateFormatted));
    }

}

package de.bot;

import de.bot.rest.GetHelloController;
import de.bot.rest.PostQuestionController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;


@ExtendWith(MockitoExtension.class)
public class ChatBotMockMVCTest {


    @InjectMocks
    static GetHelloController getHelloController;

    @InjectMocks
    static PostQuestionController postQuestionController;

    @BeforeEach
    void initialiseRestAssuredStandaloneSetup() {
        RestAssuredMockMvc.standaloneSetup(getHelloController, postQuestionController);
    }

    @Test
    public void getHelloTest() {
        given().get("/")
                .then()
                .body(is(equalTo("Hello I'm alive")))
                .statusCode(OK.value());
    }

    @Test
    public void givenMyNameThenBotShouldGreetMeWithIt() {
        String message = "My name is Mr. Test";
        String expected = "Nice to meet you, Mr Test.";

        given().body(message)
                .post("/")
                .then()
                .body(is(equalTo(expected)))
                .statusCode(OK.value());
    }

    @Test
    public void givenHelloBotThenBotShouldSayHelloHuman() {
        String message = "hello bot";
        String expected = "Hello human.";

        given().body(message)
                .post("/")
                .then()
                .body(is(equalTo(expected)))
                .statusCode(OK.value());
    }
}



# Coding Academy

Coding academy - date 26th Oct in Hamburg

## Allgemeine Agenda

* 9.00 bis 9.30Uhr: Begrüßung der Teilnehmer und Vorstellung vonHC (alle Teilnehmer zusammen)
* 9.30 bis 10.00Uhr: Allg. Intro Coding (?) + Raumwechsel
* 10.00 bis 12.00Uhr: Workshop (in Gruppen)
* 12.00 bis 13.00Uhr: Lunch (alle Teilnehmer zusammen)
* 13.00 bis 15.30Uhr: Workshop (in Gruppen)
* 15.30 bis 16.00Uhr: Präsentation der Ergebnisse aus Workshop 1 (alle Teilnehmer zusammen)
* 16.00 bis 16.30Uhr: Präsentation der Ergebnisse aus Workshop 2 (alle Teilnehmer zusammen)  
* 16.30 bis 17.00Uhr: Präsentation der Ergebnisse aus Workshop 3 (alle Teilnehmer zusammen)  

## Preparation

- Fragen an Svenja:
  * Noch GIT installieren ?
  * Was ist der Inhalt von Svenjas Intro? Dauert es 1 Stunde?
  * Was soll in der Ergebnispräsentation gezeigt werden und von wem?
  * Wann ist Mittagessen?  --> *Fred schreibt Mail*
        
          
        Hallo Frederik,
        
        GIT habe ich aufgenommen und wird installiert.
        Es werden 30 Stand-alone Rechner in HH zur Verfügung gestellt. Ich kümmere mich am Tag vor der Veranstaltung mit HC Praktis und ggf. Unterstützung des IT Service Point in HH um die Installation.
        
        Wie gerade schon besprochen - für die Workshopplanung könnt ihr mit dieser voraussichtlichen Agenda planen:
        
        | 9.00 bis 9.30Uhr: Begrüßung der Teilnehmer und Vorstellung vonHC (alle Teilnehmer zusammen)
        | 9.30 bis 10.00Uhr: Allg. Intro Coding (?) + Raumwechsel
        | 10.00 bis 12.00Uhr: Workshop (in Gruppen)
        | 12.00 bis 13.00Uhr: Lunch (alle Teilnehmer zusammen)
        | 13.00 bis 15.30Uhr: Workshop (in Gruppen)
        | 15.30 bis 16.00Uhr: Präsentation der Ergebnisse aus Workshop 1 (alle Teilnehmer zusammen)
        | 16.00 bis 16.30Uhr: Präsentation der Ergebnisse aus Workshop 2 (alle Teilnehmer zusammen)  
        | 16.30 bis 17.00Uhr: Präsentation der Ergebnisse aus Workshop 3 (alle Teilnehmer zusammen)  
        
        Bei Rückfragen melde dich gerne. Ansonsten wird am Dienstag weitere Infos geben.
        
        Viele Grüße
        Svenja
        

- Check der Hardware und Software auf den Rechnern
  * gitshell, docker, IDE

- Handouts:
  * Links und Resources im github zu Verfügung stellen
  * Handout for Setup Project in IDE - *Fred*
  * Handout TDD - *Alex*
  * Handout git commands - *Alex*

## Agenda

### Intro (10 Uhr - max. 10:45)

- Wer sind wir?  
- Ziel von der heutigen Session:
   - nicht nur JAVA, sondern Best-Practices in der SW-Entwicklung
- Technologien / Prinzipien:
   - JAVA  - *Alex/Fred*
     - JetBrains-Page https://www.jetbrains.com/research/devecosystem-2018/java/
     - TIOBE-Index (https://www.tiobe.com/tiobe-index/) 
     - OO-Prgramming (optional)
   - Rivescript https://rivescript.com/ - *Alex*
   - SpringBoot - *Alex*
   - Harmcrest for testing - *Alex*
   - Maven - *Fred*
   - GIT - *Alex*
   - Docker - *Fred*
   - Test-Driven-Development (TDD) - *Alex/Fred*
   - DevOps - *Alex/Fred*
   - Pair-Programming - https://en.wikipedia.org/wiki/Pair_programming
   
- Gruppen von max. 3 Personen (ideal 2) zum programmieren
   
- Fazit: 
   - *Programmieren können viele, aber Software entwickeln nur wenige!*
   - Qualität - Testing (TDD)
   - Automatisierung - "Automate everything!"  
   - Wiederverwendung - "Don't reinvent the wheel!"

- 15 min Pause (Open IDE)


### PART 1 (10:45 - 12 Uhr)
- Programmieren ChatBot (nach jedem Schritt 'git commit')
   * Create a new Maven project 
      * GrouppId = de.example.chatbot / artifactId = chatbot
      * See https://maven.apache.org/guides/mini/guide-naming-conventions.html for GroupId / ArtifactId
   * Create de.example.codingacademy.Chatbot Class (empty)
   * git init pom.xml and empty chtabot class
   * Writing 1st test together
      * Add harmcrest for testing https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all/1.3 to pom.xml
      * JAVA-Annotation: "In the Java computer programming language, an annotation is a form of syntactic metadata that can be added to Java source code.
        Classes, methods, variables, parameters and packages may be annotated."
      * create test-class ChatBotTest
         * test method sayHelloBot() which tests method of chatbot getReply()
      
   * Then new potentials should add >=2 more tests
      * discuss the tests for 10 min
      * when tests are written then commit
   * Implement logic of class ChatBot
      * go to rivescript playground https://play.rivescript.com/
      * Rivecript: How does it work see 
      * add maven dependency https://mvnrepository.com/artifact/com.rivescript/rivescript-core/0.10.0
      * New potential should work on their own in groups for 30 min
         * also create rivescript files in resources/rivescript
      * discussion during coding
      * Sample solution:
        
        ```java
        import com.rivescript.Config;
        import com.rivescript.RiveScript;
        
        public class ChatBot {
        
            private RiveScript bot;
        
            public ChatBot() {
                String rivescriptFilePath = ChatBot.class.getClassLoader().getResource("rivescript").getFile();
                bot = new RiveScript(Config.utf8());
                bot.loadDirectory(rivescriptFilePath);
                bot.sortReplies();
            }   
        
            public String getMsg(String msg) {
                return bot.reply("user", msg);
            }   
        }
        ```
      * Create MainClass with main() to call chatbot. Sample solution:
        
        ```java
        import java.util.Scanner;
        
        public class MainClass {
        
            public static void main(String[] args) {
                ChatBot bot = new ChatBot();
                Scanner scanner = new Scanner(System.in);
                String your_msg = ""; 
                while (!your_msg.equalsIgnoreCase("bye")) {
                    System.out.print("you: "); 
                    your_msg = scanner.nextLine();
                    String response = bot.getMsg(your_msg);
                    System.out.println("bot: " + response);
                }   
            }   
        }
        ```

   * show a more complex example like "swear-word case" in Rivescript
   * refer to DialogFlow / RASA as alteratives
   * RESULT: Finally talk in the console (IDE) to your chatbot 
 
- Mittag 12-13:00 Uhr

### PART 2 (13-15:15 Uhr)
- Programmieren eines RESTful-Web-Service für den ChatBot via SpringBoot
  * Um den Bot via HTTP anzusprechen, implementieren wir nun einen REST/HTTP server mit dem SpringBoot-Framework
  * maven deps for SpringBoot
  * neues Package 'rest' 
     * eigentlich auch hier zuerst den Test schreiben mit MockMVC! 
        * aus Zeitgründen überspringen wir das
     * neue Klasse ChatBotApp als @SpringBootApplication
     * neue Klasse GetHelloController mit GetMapping("/")
     * dann committen
     * neuen Klasse PostMsgController als @PostMapping("/")
     * 
  * show how to program the Controller for GET / (say hello) and POST message 
  * optional: TDD also here with MockMVC but cause of time reasons we skip that today
  * refer to MongoDB and user/session handling as even more functions needed for real runnig chatbot
- Docker:
  * Create Dockerfile, Build image and run image - *@Fred: Prepare Dockerfile*
  * Test chatbot in Docker via Postman
 
### Wrap-Up (15:15 - 15:30 Uhr)
- Was haben wir heute gelernt? Die wichtigsten Punkte nochmal ansprechen:
  - Automatisierung - "Automate everything!"  
  - Wiederverwendung - "Don't reinvent the wheel!"
  - Qualität und Code-Struktur durch TDD
  - Docker für DevOps
  - GIT für Versionierung und Sharing Code
  

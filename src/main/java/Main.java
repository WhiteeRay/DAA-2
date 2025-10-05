import cli.CommandLineApp;


import java.io.IOException;

public class Main{

    public static void main(String args[]) {
        try {
            CommandLineApp.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
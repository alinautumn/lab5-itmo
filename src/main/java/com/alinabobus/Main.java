package com.alinabobus;

import com.alinabobus.utility.*;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;


public final class Main {
    static final String ENVIRONMENT_VARIABLE = "PROG_PATH";

    private Main() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }


    public static void main(String[] args) {

        final OutputManager outputManager = new OutputManager();
        final HistoryManager historyManager = new HistoryManager();

        final CollectionManager collectionManager = new CollectionManager();
        final FileManager fileManager = new FileManager(ENVIRONMENT_VARIABLE);
        final UserInputManager userInputManager = new UserInputManager();
        final CommandManager commandManager = new CommandManager(fileManager, userInputManager, collectionManager, outputManager, historyManager);
        final CommandRunManager commandRunManager = new CommandRunManager(commandManager, historyManager);
        final Console console = new Console(fileManager,
                userInputManager, collectionManager, outputManager,
                commandRunManager);
        try {
            console.start();
        } catch (JsonSyntaxException | IllegalArgumentException e) {
            outputManager.println("The file does not keep data in correct format.");
        } catch (IOException e) {
            outputManager.println("Could not read the file. Check if it is available.");
        } catch (Exception e) {
            outputManager.println("Could not execute the program");
        }
    }
}
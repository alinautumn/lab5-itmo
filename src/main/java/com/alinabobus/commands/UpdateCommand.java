package com.alinabobus.commands;

import com.alinabobus.data.Route;
import com.alinabobus.utility.CollectionManager;
import com.alinabobus.utility.OutputManager;
import com.alinabobus.utility.RouteMaker;
import com.alinabobus.utility.UserInputManager;

public class UpdateCommand extends Command {
    private final OutputManager outputManager;
    private final UserInputManager userInputManager;
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("update");
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        int intArg;
        try {
            intArg = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }

        if (collectionManager.removeById(intArg)) {
            Route route = new RouteMaker(userInputManager, outputManager, collectionManager).makeRoute();
            route.setId(intArg);
            collectionManager.getMainData().add(route);
            return new CommandResult(false, "The element was updated successfully");
        } else {
            return new CommandResult(false, "Written id was not found. The command was not executed");
        }
    }
}

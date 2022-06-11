package com.alinabobus.commands;

import com.alinabobus.utility.CollectionManager;
import com.alinabobus.utility.RouteMaker;
import com.alinabobus.data.Route;
import com.alinabobus.utility.OutputManager;
import com.alinabobus.utility.UserInputManager;

public class AddIfMaxCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMaxCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add_if_max");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Route route = new RouteMaker(userInputManager, outputManager, collectionManager).makeRoute();

        if (collectionManager.addIfMax(route)) {
            return new CommandResult(false, "The element was added successfully");
        } else {
            return new CommandResult(false, "The element was not max, so it was not added");
        }
    }

}

package com.alinabobus.commands;

import com.alinabobus.utility.CollectionManager;

public class RemoveAnyByDistanceCommand extends Command {
    private final CollectionManager collectionManager;

    public RemoveAnyByDistanceCommand(CollectionManager collectionManager) {
        super("remove_any_by_distance");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        long longArg;
        try {
            longArg = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }


        if (collectionManager.getMainData().removeIf(x -> x.getDistance() == longArg)) {
            return new CommandResult(false, "The element was deleted successfully.");
        } else {
            return new CommandResult(false, "Could not find written distance. The command was not executed");
        }
    }

}

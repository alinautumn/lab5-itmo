package com.alinabobus.commands;

import com.alinabobus.utility.CollectionManager;

public class InfoCommand extends Command {
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (!collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate());
        } else {
            return new CommandResult(false, "Collection type: " + collectionManager.getMainData().getClass().toString() + "\n"
                    + "Number of elements: " + collectionManager.getMainData().size() + "\n"
                    + "Creation date: " + collectionManager.getCreationDate());
        }
    }
}

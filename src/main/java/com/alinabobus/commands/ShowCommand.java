package com.alinabobus.commands;

import com.alinabobus.utility.CollectionManager;
import com.alinabobus.data.Route;

import java.util.StringJoiner;

public class ShowCommand extends Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");
        if (collectionManager.getMainData().isEmpty()) {
            return new CommandResult(false, "Collection is empty");
        }
        for (Route route : collectionManager.getMainData()) {
            output.add(route.toString());
        }

        return new CommandResult(false, output.toString());
    }
}

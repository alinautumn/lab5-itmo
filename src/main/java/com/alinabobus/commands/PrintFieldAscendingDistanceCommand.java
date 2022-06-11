package com.alinabobus.commands;

import com.alinabobus.utility.CollectionManager;
import com.alinabobus.data.Route;

import java.util.StringJoiner;

public class PrintFieldAscendingDistanceCommand extends Command {
    private final CollectionManager collectionManager;

    public PrintFieldAscendingDistanceCommand(CollectionManager collectionManager) {
        super("print_field_ascending_distance");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");

        for (Route route : collectionManager.getMainData()) {
            output.add(route.toString());
        }

        return new CommandResult(false, output.toString());
    }
}

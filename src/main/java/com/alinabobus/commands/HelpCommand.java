package com.alinabobus.commands;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false,
                """
                        help : gives information about available commands
                        info : gives information about collection
                        show : shows every element in collection with string
                        add {element} : adds new element to collection
                        update id {element} : update element info by it's id
                        remove_by_id id : delete element by it's id
                        clear : clears collection
                        save : saves collection to a file
                        execute_script file_name : executes script entered in a file
                        exit : exits the program (!!!does not save data!!!)
                        add_if_min {element} : adds new element to the collection if it's value less than min element's value
                        add_if_max {element} : adds new element to the collection if it's value less than that of the smallest item in this collection
                        history : shows last 14 command usages
                        remove_any_by_distance : deletes one element from the collection, the value of the distance field of which is equivalent to the specified
                        average_of_distance : prints the average value of the distance field for all elements of the collection
                        print_field_ascending_distance : prints the values of the distance field of all elements in ascending order""");
    }
}

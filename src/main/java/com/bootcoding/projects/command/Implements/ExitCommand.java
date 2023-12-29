package com.bootcoding.projects.command.Implements;

import com.bootcoding.projects.command.Command;
import com.bootcoding.projects.command.validator.CommandValidator;
import com.bootcoding.projects.model.Result;

public class ExitCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        return Result.builder().message("Exiting applicatin").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if (attributes.length != 1) {
            throw new Exception("Invalid command arguments: Use 'exit' to exit");
        }
        if (!attributes[0].equals("exit")) {
            throw new Exception("Action is not exit!");
        }
        return true;
    }
}

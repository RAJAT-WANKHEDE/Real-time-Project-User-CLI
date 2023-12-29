package com.bootcoding.projects.command.Implements;

import com.bootcoding.projects.command.Command;
import com.bootcoding.projects.command.validator.CommandValidator;
import com.bootcoding.projects.model.Result;
import com.bootcoding.projects.model.User;
import com.bootcoding.projects.store.InMemoryStore;

import java.util.List;

public class DeleteCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) throws Exception {
        if (validate(attributes)) {
            String id = attributes[2];
            List<User> users = InMemoryStore.users;
            User userToDelete = null;
            for (User user : users) {
                if (user.getId().equals(id)) {
                    userToDelete = user;
                    break;
                }
            }
            if (userToDelete != null) {
                users.remove(userToDelete);
                return Result.builder().message("SUCCESS").users(users).build();
            } else {
                return Result.builder().message("User not found").build();
            }
        }
        return Result.builder().message("Invalid command arguments").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if (attributes.length != 3){
            throw new Exception("Please Enter Valid Detail to delete user");
        }

        if (!attributes[0].equals("delete")){
            throw new Exception("Action is not delete !");
        }

        if(!attributes[1].equals("-i")){
            throw new Exception("Invalid command attribute format ");
        }
        return true;
    }

}

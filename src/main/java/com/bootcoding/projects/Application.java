package com.bootcoding.projects;

import com.bootcoding.projects.command.Command;
import com.bootcoding.projects.command.Implements.*;
import com.bootcoding.projects.model.Result;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("======================= Bootcoding Command Utility =================");
            System.out.println("To create User, command should be like ::: create -n name -p phone -a addr -e emailId");
            System.out.println("You are free to enter any command!");

            String commandStr = sc.nextLine();

            String[] commandWithAttrs = commandStr.split(" ");
            Command command = findCommand(commandWithAttrs[0]);
            if(null == command || command instanceof ExitCommand){
                break;
            }
            try {
                Result result = command.execute(commandWithAttrs);
                System.out.println(result);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    private static Command findCommand(String cmd) {
        switch (cmd){
            case "create":
                Command command = new CreateCommand();
                return command;
            case "read":
                return new ReadCommand();
            case "update":
                return new UpdateCommand();
            case "delete":
                return new DeleteCommand();
            default:
                return null;
        }
    }
}

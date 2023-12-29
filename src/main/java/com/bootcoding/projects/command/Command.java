package com.bootcoding.projects.command;

import com.bootcoding.projects.model.Result;

public interface Command {
    public Result execute(String[] attributes) throws Exception;
}

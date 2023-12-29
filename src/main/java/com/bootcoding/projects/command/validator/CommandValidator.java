package com.bootcoding.projects.command.validator;

public interface CommandValidator {
    public boolean validate(String[] attributes) throws Exception;
}

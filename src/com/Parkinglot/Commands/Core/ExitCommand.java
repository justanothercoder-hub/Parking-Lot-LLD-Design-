package com.Parkinglot.Commands.Core;

import com.Parkinglot.Commands.Command;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] inputs) {
        System.exit(0);
    }
}

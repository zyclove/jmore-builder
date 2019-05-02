package com.whatakitty.jmore.console.demo.domain.command;

import com.whatakitty.jmore.console.domain.context.ConsoleContext;
import com.whatakitty.jmore.console.domain.command.ICommand;
import com.whatakitty.jmore.console.domain.command.CommandParser;
import org.springframework.stereotype.Component;

/**
 * simple demo of command parser
 *
 * @author WhatAKitty
 * @date 2019/05/02
 * @description
 **/
@Component
public class DemoCommandParser extends CommandParser {

    @Override
    public ICommand parse(ConsoleContext context, String command) {
        switch (command) {
            case SayHelloWorldCommand.COMMAND_TIP:
                SayHelloWorldCommand cmd = new SayHelloWorldCommand(context);
                context.setCurrentCommand(cmd);
                return cmd;
            case ShowHistoryCommand.COMMAND_TIP:
                ShowHistoryCommand showHistoryCommand = new ShowHistoryCommand(context);
                context.setCurrentCommand(showHistoryCommand);
                return showHistoryCommand;
            default:
                throw new UnsupportedOperationException(String.format("unsupported command %s", command));
        }
    }

}

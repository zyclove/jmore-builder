package com.whatakitty.jmore.console.domain.history;

import com.whatakitty.jmore.console.domain.command.ICommand;
import com.whatakitty.jmore.console.domain.context.ConsoleContext;
import com.whatakitty.jmore.framework.ddd.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * command snapshot
 *
 * @author WhatAKitty
 * @date 2019/05/02
 * @description
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CommandSnapshot extends AbstractEntity {

    private final String name;
    private final ICommand command;

    public void undo(ConsoleContext context) {
        command.undo(context);
    }

}

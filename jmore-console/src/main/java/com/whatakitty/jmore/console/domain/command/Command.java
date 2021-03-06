package com.whatakitty.jmore.console.domain.command;

import com.whatakitty.jmore.console.domain.command.event.CommandAfterExecuteEvent;
import com.whatakitty.jmore.console.domain.command.event.CommandBeforeExecuteEvent;
import com.whatakitty.jmore.console.domain.command.event.CommandExecuteFailedEvent;
import com.whatakitty.jmore.console.domain.command.event.CommandFinishedEvent;
import com.whatakitty.jmore.console.domain.context.ConsoleContext;
import com.whatakitty.jmore.framework.ddd.domain.AbstractAggregateRoot;
import com.whatakitty.jmore.framework.ddd.publishedlanguage.AggregateId;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Command aggregate root
 *
 * behavior:
 * 1. execute
 * 2. undo
 *
 * @author WhatAKitty
 * @date 2019/05/01
 * @description
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Command extends AbstractAggregateRoot<String> implements ICommand {

    /**
     * command name
     */
    private final String name;
    /**
     * the receiver to actually execute
     */
    private final IReceiver receiver;

    public Command(AggregateId<String> id, String name, IReceiver receiver) {
        super(id);
        this.name = name;
        this.receiver = receiver;
    }

    @Override
    public CommandResult execute(ConsoleContext context) {
        publishEvent(new CommandBeforeExecuteEvent(context));
        try {
            // invoke
            final Object result = execute(context, receiver);
            publishEvent(new CommandAfterExecuteEvent(context, result));
            return CommandResult.of(true, result);
        } catch (Throwable e) {
            publishEvent(new CommandExecuteFailedEvent(context, e));
            return CommandResult.of(false, null);
        } finally {
            publishEvent(new CommandFinishedEvent(context));
        }
    }

    @Override
    public void undo(ConsoleContext context) {
        if (!supportUndo()) {
            throw new UnsupportedOperationException("unsupported undo operation");
        }
        // undo
        undo(context, receiver);
    }

    /**
     * create a batch command task
     *
     * @param commands commands list
     * @return batch command instance
     */
    public static BatchCommand createBatch(List<ICommand> commands) {
        return new BatchCommand(commands);
    }

    protected abstract Object execute(ConsoleContext context, IReceiver receiver);

    protected Object undo(ConsoleContext context, IReceiver receiver) {
        return null;
    }

}

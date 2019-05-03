package com.whatakitty.jmore.console.demo.infrastructure;

import com.whatakitty.jmore.console.demo.domain.command.SayHelloWorldCommand;
import com.whatakitty.jmore.console.infrastructure.DefaultCommandRepository;
import com.whatakitty.jmore.framework.ddd.publishedlanguage.AggregateId;
import org.springframework.stereotype.Component;

/**
 * demo command repository
 *
 * @author WhatAKitty
 * @date 2019/05/03
 * @description
 **/
@Component
public class DemoCommandRepository extends DefaultCommandRepository {

    static {
        holder.put(new AggregateId<>(SayHelloWorldCommand.COMMAND_TIP), new SayHelloWorldCommand());
    }

}

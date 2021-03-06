package com.whatakitty.jmore.console.demo;

import com.whatakitty.jmore.console.JMoreConsoleRunner;
import com.whatakitty.jmore.console.application.service.CommandService;
import com.whatakitty.jmore.console.domain.command.CommandResult;
import com.whatakitty.jmore.console.domain.context.ConsoleContext;
import com.whatakitty.jmore.console.infrastructure.stream.StreamMgr;
import com.whatakitty.jmore.framework.bootstrap.JMoreApplication;
import java.util.Optional;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * example console application base on jmore console
 *
 * @author WhatAKitty
 * @date 2019/04/23
 * @description
 **/
@Slf4j
@RequiredArgsConstructor
@SpringBootApplication(scanBasePackages = "com.whatakitty.jmore")
public class Application implements JMoreConsoleRunner {

    private final CommandService commandService;

    @Override
    public void run(ConsoleContext context) {
        final String command = StreamMgr.getINSTANCE().reader().nextLine();
        try {
            Optional<CommandResult> result = commandService.execute(context, command);
            if (!result.isPresent() || !result.get().isSucc()) {
                StreamMgr.getINSTANCE().println("Command execute failed");
            }
            run(context);
        } catch (UnsupportedOperationException e) {
            log.error(e.getMessage());
        }
    }

    @PreDestroy
    public void destroy() {

    }

    public static void main(String[] args) {
        JMoreApplication.run(Application.class, args);
    }

}

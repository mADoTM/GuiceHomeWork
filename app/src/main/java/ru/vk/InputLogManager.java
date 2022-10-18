package ru.vk;

import com.google.inject.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;

public class InputLogManager implements MethodInterceptor {
    private final @NotNull Provider<Logger> logger;

    private final @NotNull String tag;

    @Inject
    public InputLogManager(@NotNull Provider<Logger> logger, @NotNull String tag) {
        this.logger = logger;
        this.tag = tag;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodMessage = invocation.getArguments()[0].toString();

        logger.get().doLog(getMessage(methodMessage));

        return invocation.proceed();
    }

    private @NotNull String getMessage(String data) {
        return  "<"+ tag + ">"
                + data +
                "<"+ tag + ">";
    }
}

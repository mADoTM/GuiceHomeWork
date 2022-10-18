package ru.vk;

import com.google.inject.name.Named;


import com.google.inject.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;

public class InputLogManager implements MethodInterceptor {
    @Inject(optional = true)
    @Named("console_logger")
    private Logger logger1;

    @Inject(optional = true)
    @Named("file_logger")
    private Logger logger2;

    @Inject
    @Named("logging_tag")
    private String tag;

    private int id = 0;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodMessage = invocation.getArguments()[0].toString();

        if(logger1 != null) {
            logger1.doLog(getMessage(methodMessage));
        }
        if(logger2 != null) {
            logger2.doLog(getMessage(methodMessage));
        }

        return invocation.proceed();
    }

    private @NotNull String getMessage(String data) {
        return (id++) +
                "<"+ tag + ">"
                + data +
                "<"+ tag + ">";
    }
}

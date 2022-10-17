package ru.vk;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import org.aopalliance.intercept.MethodInterceptor;
import org.jetbrains.annotations.NotNull;

public class ApplicationModule extends AbstractModule {
    private final @NotNull LoggingType type;
    private final @NotNull String tag;

    public ApplicationModule(@NotNull LoggingType type,
                             @NotNull String tag) {
        this.type = type;
        this.tag = tag;
    }
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("logging_tag")).toInstance(tag);
        bind(Application.class);

        enableLoggers();

        MethodInterceptor interceptor = new InputLogManager();
        requestInjection(interceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(InputLogAnnotation.class), interceptor);
    }

    private void enableLoggers() {
        if(type == LoggingType.Compose || type == LoggingType.Console) {
            bind(Logger.class).annotatedWith(Names.named("console_logger")).to(ConsoleLogger.class);
        }
        if(type == LoggingType.Compose || type == LoggingType.File) {
            bind(Logger.class).annotatedWith(Names.named("file_logger")).to(FileLogger.class);
        }
    }
}

package ru.vk;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
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
        enableLoggers();
        bind(String.class).annotatedWith(Names.named("logging_tag")).toInstance(tag);
        bind(Application.class);
    }

    private void enableLoggers() {
        if(type == LoggingType.Console) {
            bind(Logger.class).to(ConsoleLogger.class);
        }
        if(type == LoggingType.File) {
            bind(Logger.class).to(FileLogger.class);
        }
        if(type == LoggingType.Compose) {
            Multibinder<Logger> multiBinder = Multibinder.newSetBinder(binder(), Logger.class);
            multiBinder.addBinding().to(ConsoleLogger.class);
            multiBinder.addBinding().to(FileLogger.class);
            bind(Logger.class).to(ComposeLogger.class);
        }
    }
}

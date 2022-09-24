package com.kjoshi.basicms.helloworld.config;

import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import io.github.resilience4j.retry.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldBeansConfig {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldBeansConfig.class);

    @Bean
    public RegistryEventConsumer<Retry> configureRetry(){
        logger.info("Configuring Retry Registry");
        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<Retry> entryAddedEvent) {
                logger.info("Adding Entry of event {}", entryAddedEvent.getEventType().name());
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<Retry> entryRemoveEvent) {
                logger.info("Removing Entry of event {}", entryRemoveEvent.getEventType().name());
            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<Retry> entryReplacedEvent) {
                logger.info("Replacing Entry of event {}", entryReplacedEvent.getEventType().name());
            }
        };
    }
}

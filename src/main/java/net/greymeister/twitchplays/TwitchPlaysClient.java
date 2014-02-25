package net.greymeister.twitchplays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class TwitchPlaysClient {
    private static final Logger LOG = LoggerFactory.getLogger(TwitchPlaysClient.class);

    @SuppressWarnings("RedundantNoArgConstructor")
    public TwitchPlaysClient() {
    }

    private void runBackground() {
        LOG.info("Initializing Spring context.");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ((AbstractApplicationContext) applicationContext).registerShutdownHook();
        LOG.info("Spring context initialized.");
    }

    public static void main(String[] args) {
        new TwitchPlaysClient().runBackground();
    }
}

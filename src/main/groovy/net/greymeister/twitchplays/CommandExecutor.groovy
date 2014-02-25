package net.greymeister.twitchplays

import net.greymeister.twitchplays.execute.CommandToKeyPress
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.integration.Message
import org.springframework.integration.MessagingException
import org.springframework.integration.core.MessageHandler
import org.springframework.stereotype.Service

import java.awt.Robot

@Service
public class CommandExecutor implements MessageHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CommandExecutor.class);
    private Robot robot

    CommandExecutor() {
        robot = new Robot()
    }

    @Override
    void handleMessage(Message<?> message) throws MessagingException {
        LOG.info("Received message: {}", message.getPayload().toString())
        CommandMessage commandMessage = new CommandMessage(message.getPayload().toString());
        produceOutputCommand(commandMessage)
    }

    private void produceOutputCommand(CommandMessage commandMessage) {
        int key = CommandToKeyPress.commandToKeyEvent(commandMessage.getCommand())
        if (key != 0) {
            robot.keyPress(key)
        }
    }
}
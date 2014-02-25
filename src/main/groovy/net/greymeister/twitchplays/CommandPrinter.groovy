package net.greymeister.twitchplays

import net.greymeister.twitchplays.print.CommandToUnicodeString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.integration.Message
import org.springframework.integration.MessagingException
import org.springframework.integration.core.MessageHandler
import org.springframework.stereotype.Service

import javax.swing.*
import java.awt.*

@Service
public class CommandPrinter implements MessageHandler, InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(CommandPrinter.class)

    protected CommandPanel panel

    @Override
    void handleMessage(Message<?> message) throws MessagingException {
        LOG.debug('Received message: {}', message.getPayload())
        CommandMessage commandMessage = new CommandMessage(message.getPayload().toString())
        String command = CommandToUnicodeString.commandToUnicode(commandMessage.getCommand())
        LOG.debug('Parsed Command: {}', command)
        if (command != null) {
            StringBuilder builder = new StringBuilder(commandMessage.getUsername()).append(" : ").append(command).append('\n')
            panel.appendText(builder.toString())
        }
    }

    @Override
    void afterPropertiesSet() throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                panel = CommandPanel.createAndShowGUI()
            }
        })
    }

    static class CommandPanel extends JPanel {
        protected JTextArea textArea

        CommandPanel() {
            super(new GridBagLayout())

            textArea = new JTextArea(20, 50)
            textArea.setEditable(false)
            JScrollPane scrollPane = new JScrollPane(textArea)

            //Add Components to this panel.
            GridBagConstraints c = new GridBagConstraints()
            c.gridwidth = GridBagConstraints.REMAINDER

            c.fill = GridBagConstraints.HORIZONTAL

            c.fill = GridBagConstraints.BOTH
            c.weightx = 1.0
            c.weighty = 1.0
            add(scrollPane, c)
        }

        public void appendText(String text) {
            textArea.append(text)
            textArea.setCaretPosition(textArea.getDocument().length)
        }

        /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event dispatch thread.
         */
        public static CommandPanel createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame('Twitch Rabbot Client')
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

            //Add contents to the window.
            CommandPanel panel = new CommandPanel()
            frame.add(panel)

            //Display the window.
            frame.pack()
            frame.setVisible(true)
            return panel
        }

    }
}
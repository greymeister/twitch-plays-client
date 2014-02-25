package net.greymeister.twitchplays;

import com.google.common.base.Splitter;

import java.util.Iterator;

public class CommandMessage {

    private final String username;
    private final String command;
    private final String time;

    public CommandMessage(String payload) {
        Iterator<String> csvIterator = Splitter.on(',').split(payload).iterator();
        String[] values = {
                (csvIterator.hasNext() ? csvIterator.next() : null),
                (csvIterator.hasNext() ? csvIterator.next() : null),
                (csvIterator.hasNext() ? csvIterator.next() : null),
        };
        username = values[0];
        command = values[1];
        time = values[2];
    }

    public String getUsername() {
        return username;
    }

    public String getCommand() {
        return command;
    }

    public String getTime() {
        return time;
    }
}

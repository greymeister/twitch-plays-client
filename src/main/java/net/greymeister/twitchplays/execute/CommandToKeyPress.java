package net.greymeister.twitchplays.execute;

import java.awt.event.KeyEvent;

public class CommandToKeyPress {
    private CommandToKeyPress() {
    }

    public static int commandToKeyEvent(String command) {
        switch (command) {
            case "up":
                return KeyEvent.VK_UP;
            case "left":
                return KeyEvent.VK_LEFT;
            case "right":
                return KeyEvent.VK_RIGHT;
            case "down":
                return KeyEvent.VK_DOWN;
            case "start":
                return KeyEvent.VK_ENTER;
            case "select":
                return KeyEvent.VK_ALT;
            case "a":
                return KeyEvent.VK_A;
            case "b":
                return KeyEvent.VK_B;
            case "x":
                return KeyEvent.VK_X;
            case "y":
                return KeyEvent.VK_Y;
            case "l":
                return KeyEvent.VK_L;
            case "r":
                return KeyEvent.VK_R;
            default:
                return 0;
        }

    }
}

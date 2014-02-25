package net.greymeister.twitchplays.print;

public class CommandToUnicodeString {

    private CommandToUnicodeString() {}

    public static String commandToUnicode(String command) {
        switch (command) {
            case "up":
                return "↑";
            case "left":
                return "←";
            case "right":
                return "→";
            case "down":
                return "↓";
            case "start":
                return "START";
            case "select":
                return "SEL";
            case "a":
                return "A";
            case "b":
                return "B";
            case "x":
                return "X";
            case "y":
                return "Y";
            case "l":
                return "L";
            case "r":
                return "R";
            default:
                return null;
        }
    }

}

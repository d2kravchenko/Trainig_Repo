package utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotScenario {

    public static void pasteAndEnter(){

        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.delay(300);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(200);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {e.printStackTrace();}

    }

}

package temp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * 익명클래스 1
 */
public class Test13 {

    public static void main(String[] args) {
        Button b    = new Button("Start");
        b.addActionListener(new EventHandlerr());
    }
}

class EventHandlerr implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent Go!!!!!!!!!!!!");
    }
}

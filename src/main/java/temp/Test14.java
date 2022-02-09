package temp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 익명클래스 2
 * Test13을 익명클래스화
 */
public class Test14 {

    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent Go!!!!!!!!!!!!");
            }
        });
    }
}

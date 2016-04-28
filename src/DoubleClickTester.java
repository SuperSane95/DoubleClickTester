import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class DoubleClickTester extends JFrame implements MouseListener {
    private JButton test, clear;
    private JLabel msg, clicks, action;
    private JPanel text, buttons, actionPanel;
    private Integer clickCount;
    private ImageIcon icon;

    public DoubleClickTester() {
        super("Double Click Tester");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,200);
        this.load();
        this.setVisible(true);
    }

    private void load() {

        this.test = new JButton("Click to Test");
        this.clear = new JButton("Clear click count");
        this.msg = new JLabel("Your current clicks count: ");
        this.clicks = new JLabel("0");
        this.action = new JLabel("Click on button \"Test\" to begin.");
        this.actionPanel = new JPanel();
        this.actionPanel.add(this.action);
        this.clickCount = 0;
        this.text = new JPanel();
        this.text.setLayout(new GridLayout(1,2));
        this.buttons = new JPanel();
        this.buttons.setLayout(new GridLayout(1,2));
        this.test.addMouseListener(this);
        this.clear.addMouseListener(this);
        this.text.add(msg);
        this.text.add(clicks);
        this.buttons.add(test);
        this.buttons.add(clear);
        this.icon = new ImageIcon("res/mouse.png");
        this.setIconImage(this.icon.getImage());

        Container container = this.getContentPane();
        container.add(this.text, BorderLayout.CENTER);
        container.add(this.buttons, BorderLayout.PAGE_END);
        container.add(this.actionPanel, BorderLayout.PAGE_START);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        String cStr;
        if (source == this.test) {
            this.clickCount++;
            cStr = this.clickCount.toString();
            this.clicks.setText(cStr);
        } else if (source == this.clear) {
            this.clickCount = 0;
            cStr = this.clickCount.toString();
            this.action.setText("Counter cleared!");
            this.clicks.setText(cStr);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source == this.test) {
            this.action.setText("Mouse pressed!");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == this.test) {
            this.action.setText("Mouse released!");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == this.test) {
            this.action.setText("Mouse entered the button!");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == this.test) {
            this.action.setText("Mouse exited the button!");
        }
    }

}

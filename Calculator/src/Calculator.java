import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Calculator {

    public static void main(String[] args) {
        new Form1();
    }
}

class Form1 extends JFrame {

    protected String action = null;
    protected int first = 0;
    protected int second = 0;
    private float x = 0;
    private String yText = "";
    private float y = 0;
    private boolean actionIsDefined = false;
    private String currentAction;

    Form1() {
        JLabel label = new JLabel("0");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setOpaque(true);
        label.setBackground(new Color(250, 250, 250));
        label.setForeground(new Color(64, 64, 64));
        label.setBorder(new EtchedBorder());
        label.setFont(new Font("Tahoma", Font.PLAIN, 45));
        ArrayList<JButton> buttonList = getButtonArray();
        setButtonActions(buttonList, label);
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panelNubmers1 = new JPanel();
        JPanel panelNubmers2 = new JPanel();
        JPanel panelNubmers3 = new JPanel();
        JPanel panelNubmers4 = new JPanel();
        JPanel panelNubmers5 = new JPanel();
        panel0.setLayout(new BorderLayout(0, 0));
        panel1.setLayout(new GridLayout(5, 1, 0, 5));
        panelNubmers1.setLayout(new GridLayout(1, 5, 5, 0));
        panelNubmers1.add(buttonList.get(15));
        panelNubmers1.add(buttonList.get(19));
        panelNubmers1.add(buttonList.get(18));
        panelNubmers1.add(buttonList.get(17));
        panelNubmers2.setLayout(new GridLayout(1, 5, 5, 0));
        panelNubmers2.add(buttonList.get(7));
        panelNubmers2.add(buttonList.get(8));
        panelNubmers2.add(buttonList.get(9));
        panelNubmers2.add(buttonList.get(12));
        panelNubmers3.setLayout(new GridLayout(1, 5, 5, 0));
        panelNubmers3.add(buttonList.get(4));
        panelNubmers3.add(buttonList.get(5));
        panelNubmers3.add(buttonList.get(6));
        panelNubmers3.add(buttonList.get(13));
        panelNubmers4.setLayout(new GridLayout(1, 5, 5, 0));
        panelNubmers4.add(buttonList.get(1));
        panelNubmers4.add(buttonList.get(2));
        panelNubmers4.add(buttonList.get(3));
        panelNubmers4.add(buttonList.get(11));
        panelNubmers5.setLayout(new GridLayout(1, 5, 5, 0));
        panelNubmers5.add(buttonList.get(14));
        panelNubmers5.add(buttonList.get(0));
        panelNubmers5.add(buttonList.get(10));
        panelNubmers5.add(buttonList.get(16));
        panel1.add(panelNubmers1);
        panel1.add(panelNubmers2);
        panel1.add(panelNubmers3);
        panel1.add(panelNubmers4);
        panel1.add(panelNubmers5);
        panel0.add(label, BorderLayout.NORTH);
        panel0.add(panel1, BorderLayout.CENTER);
        setContentPane(panel0);
        setBounds(150, 150, 300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Калькулятор v 2.2");
        setVisible(true);
    }

    private void setButtonActions(ArrayList<JButton> buttonList, JLabel label) {
        // Действия для цифровых кнопок 
        for (int i = 0; i < 10; i++) {
            JButton b = buttonList.get(i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.getText() == "0") {
                        label.setText(b.getText());
                    } else {
                        label.setText(label.getText() + b.getText());
                    }
                    if (!actionIsDefined) {
                        x = new Float(label.getText());
                    } else {
                        yText = yText + b.getText();
                        y = new Float(yText);
                    }
                }
            });
        }
        // Действия для кнопок ариф. действий
        for (int i = 10; i < 14; i++) {
            JButton b = buttonList.get(i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    char ch = label.getText().charAt(label.getText().length() - 1);
                    if (ch != '.') {
                        if (!actionIsDefined) {
                            label.setText(label.getText() + b.getText());
                            actionIsDefined = true;
                            updateCurrentAction(label);
                        }
                    }
                }
            });
        }
        // Запятая
        buttonList.get(14).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char ch = label.getText().charAt(label.getText().length() - 1);
                if ((ch != '*') && (ch != '/') && (ch != '+') && (ch != '-') && (ch != '.')) {
                    label.setText(label.getText() + buttonList.get(14).getText());
                    if (actionIsDefined) {
                        yText = yText + buttonList.get(14).getText();
                    }
                }
            }
        });
        // Кнопка "CE"
        buttonList.get(15).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("0");
                clear();
            }
        });
        // Кнопка "="
        buttonList.get(16).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!actionIsDefined) {
                    return;
                }
                float result = 0;
                y = new Float(yText);

                try {
                    if (y == 0) {
                        label.setText("Zero devide!");
                        return;
                    }
                    if (currentAction == "*") {
                        result = x * y;
                    }
                    if (currentAction == "+") {
                        result = x + y;
                    }
                    if (currentAction == "–") {
                        result = x - y;
                    }
                    if (currentAction == "/") {
                        result = x / y;
                    }

                    if (result % 1 == 0) {
                        label.setText(Integer.toString((int) result));
                    } else {
                        label.setText(String.valueOf(result));
                    }
                    clear();
                    x = result;
                } catch (Exception e2) {

                }
            }
        });
        // +/-
        buttonList.get(19).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xt = "";
                String yt = "";

                if (!actionIsDefined) {
                    x = x * (-1);
                } else {
                    y = new Float(yText);
                    y = y * (-1);
                    yText = String.valueOf(y);
                }

                if (x % 1 == 0) {
                    xt = Integer.toString((int) x);
                } else {
                    xt = String.valueOf(x);
                }
                if (y % 1 == 0) {
                    yt = Integer.toString((int) y);
                } else {
                    yt = String.valueOf(x);
                }

                if (x != 0 && y == 0) {
                    label.setText(xt);
                }
                if (actionIsDefined && y != 0) {
                    label.setText(xt + currentAction + yt);
                }
            }
        });
        // sqrt
        buttonList.get(18).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a;
                a = Math.sqrt((double) x);
                label.setText(String.valueOf(a));
                if (a % 1 == 0) {
                    label.setText(Integer.toString((int) a));
                } else {
                    label.setText(String.valueOf(a));
                }
            }
        });
        // 1/x
        buttonList.get(17).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x != 0) {
                    x = 1 / x;
                }

                if (x % 1 == 0) {
                    label.setText(Integer.toString((int) x));
                } else {
                    label.setText(String.valueOf(x));
                }
            }
        });
    }

    private ArrayList<JButton> getButtonArray() {
        ArrayList<JButton> list = new ArrayList<JButton>();
        list.add(new JButton("0"));
        list.add(new JButton("1"));
        list.add(new JButton("2"));
        list.add(new JButton("3"));
        list.add(new JButton("4"));
        list.add(new JButton("5"));
        list.add(new JButton("6"));
        list.add(new JButton("7"));
        list.add(new JButton("8"));
        list.add(new JButton("9"));
        list.add(new JButton("+")); // 10
        list.add(new JButton("–")); // 11
        list.add(new JButton("*")); // 12
        list.add(new JButton("/")); // 13
        list.add(new JButton("."));// 14
        list.add(new JButton("C"));// 15
        list.add(new JButton("="));// 16
        list.add(new JButton("1/x"));// 17
        list.add(new JButton("sqrt"));// 18
        list.add(new JButton("+/-"));// 19
        for (JButton b : list) {
            b.setBackground(new Color(225, 225, 225));
            b.setForeground(new Color(64, 64, 64));
            b.setBorder(new EtchedBorder());
            b.setFocusPainted(false);
            b.setFont(new Font("Serif", Font.BOLD, 25));
        }
        return list;
    }

    void echo() {
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("Ca:" + currentAction);
        System.out.println("actionIsDefined:" + actionIsDefined);
        System.out.println("yText:" + yText);
    }

    void updateCurrentAction(JLabel label) {
        if (label.getText() == "0") {
            return;
        }
        if (label.getText().contains("*")) {
            currentAction = "*";
        }
        if (label.getText().contains("+")) {
            currentAction = "+";
        }
        if (label.getText().contains("–")) {
            currentAction = "–";
        }
        if (label.getText().contains("/")) {
            currentAction = "/";
        }
    }

    void clear() {
        x = 0;
        y = 0;
        currentAction = "";
        actionIsDefined = false;
        yText = "";
    }
}

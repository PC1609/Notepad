import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Function_Insert implements ActionListener {
    GUI gui;
    Function_Insert(GUI gui){
        this.gui = gui;
    }

    public void dateAndTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dt = ldt.format(formatter);
        gui.textArea.append(dt);
    }

    public void specialCWindow(){
        JDialog fileDialog = new JDialog(gui.window, "Special Characters", false);
        fileDialog.setLayout(new GridLayout(5,3));
        fileDialog.setLocation(500,300);
        fileDialog.setSize(400,200);

        JButton b1 = new JButton("€");
        b1.addActionListener(this);
        b1.setActionCommand("b1");
        JButton b2 = new JButton("©");
        b2.addActionListener(this);
        b2.setActionCommand("b2");
        JButton b3 = new JButton("µ");
        b3.addActionListener(this);
        b3.setActionCommand("b3");
        JButton b4 = new JButton("℃");
        b4.addActionListener(this);
        b4.setActionCommand("b4");
        JButton b5 = new JButton("Ω");
        b5.addActionListener(this);
        b5.setActionCommand("b5");
        JButton b6 = new JButton("ℤ");
        b6.addActionListener(this);
        b6.setActionCommand("b6");
        JButton b7 = new JButton("Θ");
        b7.addActionListener(this);
        b7.setActionCommand("b7");
        JButton b8= new JButton("Σ");
        b8.addActionListener(this);
        b8.setActionCommand("b8");
        JButton b9 = new JButton("π");
        b9.addActionListener(this);
        b9.setActionCommand("b9");
        JButton b10 = new JButton("⇞");
        b10.addActionListener(this);
        b10.setActionCommand("b10");
        JButton b11 = new JButton("∬");
        b11.addActionListener(this);
        b11.setActionCommand("b11");
        JButton b12 = new JButton("⨜");
        b12.addActionListener(this);
        b12.setActionCommand("b12");
        JButton b13 = new JButton("▲");
        b13.addActionListener(this);
        b13.setActionCommand("b13");
        JButton b14 = new JButton("☆");
        b14.addActionListener(this);
        b14.setActionCommand("b14");
        JButton b15 = new JButton("‰");
        b15.addActionListener(this);
        b15.setActionCommand("b15");

        fileDialog.add(b1);
        fileDialog.add(b2);
        fileDialog.add(b3);
        fileDialog.add(b4);
        fileDialog.add(b5);
        fileDialog.add(b6);
        fileDialog.add(b7);
        fileDialog.add(b8);
        fileDialog.add(b9);
        fileDialog.add(b10);
        fileDialog.add(b11);
        fileDialog.add(b12);
        fileDialog.add(b13);
        fileDialog.add(b14);
        fileDialog.add(b15);

        fileDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "b1": gui.textArea.append("€"); break;
            case "b2": gui.textArea.append("©");break;
            case "b3": gui.textArea.append("µ");break;
            case "b4": gui.textArea.append("℃");break;
            case "b5": gui.textArea.append("Ω");break;
            case "b6": gui.textArea.append("ℤ");break;
            case "b7": gui.textArea.append("Θ");break;
            case "b8": gui.textArea.append("Σ");break;
            case "b9": gui.textArea.append("π");break;
            case "b10": gui.textArea.append("⇞");break;
            case "b11": gui.textArea.append("∬");break;
            case "b12": gui.textArea.append("⨜");break;
            case "b13": gui.textArea.append("▲");break;
            case "b14": gui.textArea.append("☆");break;
            case "b15": gui.textArea.append("‰");break;


        }
    }

    public static void main(String[] args) {
        new Function_Insert(new GUI());
    }
}

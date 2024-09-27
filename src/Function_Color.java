import java.awt.*;

public class Function_Color {
    GUI gui;
    Function_Color(GUI gui){
        this.gui = gui;
    }

    public void changeColor(String color){
        switch (color){//can take custom color too
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(new Color(131, 225, 239));
                gui.textArea.setBackground(new Color(131, 225, 239));
                break;
            case "Peach":
                gui.window.getContentPane().setBackground(new Color(239,131,167));
                gui.textArea.setBackground(new Color(239,131,167));
                break;
            case "Yellow":
                gui.window.getContentPane().setBackground(new Color(235,235,120));
                gui.textArea.setBackground(new Color(235,235,120));
                break;
        }
    }
    public void changetextColor(String color){
        switch (color){
            case "White":
                gui.textArea.setForeground(Color.WHITE);
                break;
            case "Black":
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Blue":
                gui.textArea.setForeground(new Color(131, 225, 239));
                break;
            case "Peach":
                gui.textArea.setForeground(new Color(239,131,167));
                break;
            case "Yellow":
                gui.textArea.setForeground(new Color(235,235,120));
                break;
        }
    }

    public static void main(String[] args) {
        new Function_Color(new GUI());
    }
}

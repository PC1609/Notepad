import javax.swing.*;
import java.awt.*;

public class Function_Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman, arialBlack, helvetica,impact, courierNew,tahoma;
    String selectedFont;

    Function_Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){
        if (gui.wordWrapOn==false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true); //line breaking happens
            gui.textArea.setWrapStyleWord(true);//line doesn't break in middle of a word but btw words
            gui.iWrap.setText("Word Wrap : On");
        }else if (gui.wordWrapOn){
            gui.wordWrapOn =false;
            gui.textArea.setLineWrap(false); //line breaking happens
            gui.textArea.setWrapStyleWord(false);//line doesn't break in middle of a word but btw words
            gui.iWrap.setText("Word Wrap : Off");
        }
    }
    public void createFont(int fontsize){
        arial = new Font("Arial", Font.PLAIN, fontsize); //get the font size number from fontsize menuitem
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontsize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontsize);
        arialBlack = new Font("Arial Black", Font.PLAIN, fontsize);
        helvetica = new Font("Helvetica", Font.PLAIN, fontsize);
        impact = new Font("Impact", Font.PLAIN, fontsize);
        courierNew = new Font("Courier New", Font.PLAIN, fontsize);
        tahoma = new Font("Tahoma", Font.PLAIN, fontsize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial" :
                gui.textArea.setFont(arial);//setFont method in java that takes font object
                break;
            case "Arial Black" :
                gui.textArea.setFont(arialBlack);//setFont method in java that takes font object
                break;
            case "Comic Sans MS" :
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman" :
                gui.textArea.setFont(timesNewRoman);
                break;
            case "Courier New" :
                gui.textArea.setFont(courierNew);
                break;
            case "Tahoma" :
                gui.textArea.setFont(tahoma);
                break;
            case "Helvetica" :
                gui.textArea.setFont(helvetica);
                break;
            case "Impact" :
                gui.textArea.setFont(impact);
                break;

        }
    }
    public void fullScreen(){
        if (!gui.fullscreen){
            gui.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            gui.ifullscreen.setText("Minimise Screen");
            gui.fullscreen = true;
        }else{
            gui.window.setSize(800,600);
            gui.window.setLocation(300,125);
            gui.ifullscreen.setText("Full Screen");
            gui.fullscreen =false;
        }
    }
    public static void main(String[] args) {
        new Function_Format(new GUI());
    }
}

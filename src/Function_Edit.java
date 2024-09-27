import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Function_Edit implements ActionListener {
    GUI gui;
    JTextField findField, replaceField;
    Function_Edit(GUI gui){
        this.gui = gui;
    }
    public void undo(){
        gui.um.undo();
    }

    public void redo(){
        gui.um.redo();
    }

    public void copy(){
        gui.textArea.copy();
    }

    public void paste(){
        gui.textArea.paste();
    }

    public void cut(){
        gui.textArea.cut();
    }

    public void createFindDialog(){
        JDialog findDialog = new JDialog(gui.window, "Find", false);
        findDialog.setLayout(new FlowLayout()); //flow layout is to set the components in a line, one after another
        findDialog.setSize(400,200);
        findDialog.setLocation(500,300);

        JLabel findlabel = new JLabel("Find : ");
        findField = new JTextField(20);
        JButton findButton = new JButton("Find");
        findButton.addActionListener(this);
        findButton.setActionCommand("Find");

        findDialog.add(findlabel);
        findDialog.add(findField);
        findDialog.add(findButton);
        findDialog.setVisible(true);

    }

    public void createFindAndReplaceDialog(){
        JDialog findDialog = new JDialog(gui.window, "Find and Replace", false);
        findDialog.setLayout(new GridLayout(3,2)); //grid structure with rows and columns
        findDialog.setSize(400,200);
        findDialog.setLocation(500,300);

        JLabel findlabel = new JLabel("Find : ");
        findField = new JTextField(20);
        JLabel replacelabel = new JLabel("Replace with : ");
        replaceField = new JTextField(20);

        JButton replaceButton = new JButton("Replace once");
        replaceButton.addActionListener(this);
        replaceButton.setActionCommand("Replace");

        JButton raButton = new JButton("Replace all");
        raButton.addActionListener(this);
        raButton.setActionCommand("Replace all");

        findDialog.add(findlabel);
        findDialog.add(findField);
        findDialog.add(replacelabel);
        findDialog.add(replaceField);
        findDialog.add(replaceButton);
        findDialog.add(raButton);
        findDialog.setVisible(true);

    }

    public void findText(String str){
        String content = gui.textArea.getText();
        int index = content.indexOf(str); //selected text ke index will be starting index to search for str
        if (index!=-1){
            gui.textArea.setCaretPosition(index+str.length());
            gui.textArea.select(index, index+ str.length());
            gui.textArea.grabFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Text not found!");
        }
    }

    public void replaceText(String str, String rstr, boolean replaceAll){
        String content = gui.textArea.getText();
        if (replaceAll){
            gui.textArea.setText(content.replaceAll(str,rstr));
        }else{
            int index = content.indexOf(str);
            if (index!=-1){
                gui.textArea.select(index, index+ str.length());
                gui.textArea.replaceSelection(rstr);
            }else{
                JOptionPane.showMessageDialog(null,"Text not found!");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Find" : findText(findField.getText()); break;
            case "Replace" : replaceText(findField.getText(), replaceField.getText(), false);break;
            case "Replace all" : replaceText(findField.getText(), replaceField.getText(), true);break;
        }
    }

    public static void main(String[] args) {
        new Function_Edit(new GUI());
    }

}

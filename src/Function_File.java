import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName, fileAddress;
    Function_File(GUI gui){
        this.gui = gui;
    }

    public static void main(String[] args) {
        new Function_File(new GUI());
    }
    public void newFile(){
        gui.textArea.setText(""); //erase the current text
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null; //reset filename and address when new file made
    }

    public void open(){
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD); //choose a window, what will be written on window and then button pe kya likha hoga
        fd.setVisible(true);

        //to actually open the file, upar we wrote to open the window by filedialog
        if (fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory(); //get address of file we selected and its name
            gui.window.setTitle(fileName);
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));  //pass the name, address for it to be read
            gui.textArea.setText("");
            String line = null;
            while ((line = br.readLine())!=null){ //br reads text line by line
                gui.textArea.append(line + "\n");
            }
            br.close();
        }catch (Exception e){
            System.out.println("FILE NOT OPENED!");
        }
    }

    public void save(){
        if (fileName==null){
            saveAs();
        }
        else {

            try{
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(gui.textArea.getText());//get data from text area and write in a file
                gui.window.setTitle(fileName);
                fw.close();
            }catch (Exception e){
                System.out.println("NOT ABLE TO SAVE");
            }
        }
    }
    public void saveAs(){
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE); //not load
        fd.setVisible(true);

        if (fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try{
            FileWriter fw = new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());//get data from text area and write in a file
            fw.close();

        }catch (Exception e){
            System.out.println("CANNOT SAVE");
        }
    }
    public void exit(){
        System.exit(0); //prgm shuts down
    }
}

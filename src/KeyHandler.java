import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GUI gui;
    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){
            gui.file.newFile();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
            gui.file.open();
        }
        if (e.isControlDown() && e.getKeyCode()== KeyEvent.VK_S){ //if control key is pressed and then s key pressed
            gui.file.save();
        }
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode()== KeyEvent.VK_S){ //if shift key is pressed and then s key pressed
            gui.file.saveAs();
        }
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode()== KeyEvent.VK_X){ //if shift key is pressed and then s key pressed
            gui.file.exit();
        }
        if (e.isShiftDown() && e.getKeyCode()== KeyEvent.VK_F){
            gui.menuFile.doClick(); //show the file menu by it
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
            gui.fedit.undo();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_R){
            gui.fedit.redo();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_C){
            gui.fedit.copy();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_V){
            gui.fedit.paste();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_X){
            gui.fedit.cut();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.fedit.createFindDialog();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_W){
            gui.fedit.createFindAndReplaceDialog();
        }
        if (e.getKeyCode()==KeyEvent.VK_TAB){ //add indentation of tab behaviour
            e.consume(); //remove already existing tab behaviour
            gui.textArea.insert("     ",gui.textArea.getCaretPosition());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new KeyHandler(new GUI());
    }
}

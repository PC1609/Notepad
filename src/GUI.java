import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    //text area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    boolean fullscreen = false;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat,menuInsert, menuColor, menuView;
    //symbol bar
    JPanel symbolBar;
    JMenuItem sNew,sOpen,sSave,sCut,sCopy, sPaste, sUndo, sRedo, sFind,sFull;
    //file menu
    JMenuItem iNew,iOpen, iSave, iSaveAs,iExit;
    //format menu
    JMenuItem iWrap;
    JMenu menuFont, menuFontSize;
    JMenuItem iFontArial, iFontTNR, iFontSansRoman, iHelvetica, iImpact, iTahoma, iCourierNew, iArialBlack;
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    //color menu
    JMenu iTextColor, iBkgdColor;
    JMenuItem iColor1,iColor2,iColor3, iColor4, iColor5;
    JMenuItem iiColor1,iiColor2,iiColor3, iiColor4, iiColor5;
    //edit menu
    JMenuItem iUndo, iRedo, iCopy, iPaste, iCut, iFind, iFindAndReplace;
    //insert menu
    JMenuItem isc, dandt;
    //view menu
    JMenuItem ifullscreen;
    Function_File file = new Function_File(this);
    Function_Format fformat = new Function_Format(this);
    Function_Color fcolor = new Function_Color(this);
    Function_Edit fedit = new Function_Edit(this);
    Function_Insert finsert = new Function_Insert(this);

    KeyHandler khandler = new KeyHandler(this);

    UndoManager um = new UndoManager();

    GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColormenu();
        createEditMenu();
        createSymbolBar();
        createInsertMenu();
        createViewMenu();

        fformat.selectedFont = "Arial";
        fformat.createFont(16);
        fformat.wordWrap();

        fcolor.changeColor("White");
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public void createWindow(){
        window = new JFrame("Notepad"); //initiliased new JFrame object
        window.setSize(800,600);
        window.setLocation(300,125);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the window properly, bina iske bhi chal raha hai
    }

    public void createTextArea(){
        textArea = new JTextArea();
        textArea.addKeyListener(khandler);
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //when to display the scrollbar
        window.add(scrollPane); //adds both the scrollpane and textarea it is on
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); //remove the border of scroll from JFrame
        //window.add(textArea); this will add the text area above scrollpane and its text area amaking scrollpane invisible
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar); //not add

        menuFile = new JMenu("File ⏷");
        menuBar.add(menuFile);
        menuEdit = new JMenu("Edit ⏷");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format ⏷");
        menuBar.add(menuFormat);
        menuInsert = new JMenu("Insert ⏷");
        menuBar.add(menuInsert);
        menuColor = new JMenu("Color ⏷");
        menuBar.add(menuColor);
        menuView = new JMenu("View ⏷");
        menuBar.add(menuView);

    }

    public void createSymbolBar(){
        symbolBar = new JPanel();
        symbolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        symbolBar.setBackground(Color.WHITE);
        window.add(symbolBar, BorderLayout.NORTH);

        sNew = new JMenuItem("\uD83D\uDCC4"); // are unicode escape sequences for symbols : convert from unicode
        sNew.addActionListener(this);
        sNew.setActionCommand("sNew");
        symbolBar.add(sNew);

        sOpen = new JMenuItem("\uD83D\uDCC2"); // are unicode escape sequences for symbols : convert from unicode
        sOpen.addActionListener(this);
        sOpen.setActionCommand("sOpen");
        symbolBar.add(sOpen);

        sSave = new JMenuItem("\uD83D\uDCBE");
        sSave.addActionListener(this);
        sSave.setActionCommand("sSave");
        symbolBar.add(sSave);

        sCut = new JMenuItem("\u2704");
        sCut.addActionListener(this);
        sCut.setActionCommand("sCut");
        symbolBar.add(sCut);

        sCopy = new JMenuItem("❐");
        sCopy.addActionListener(this);
        sCopy.setActionCommand("sCopy");
        symbolBar.add(sCopy);

        sPaste = new JMenuItem("\uD83D\uDCCE");
        sPaste.addActionListener(this);
        sPaste.setActionCommand("sPaste");
        symbolBar.add(sPaste);

        sUndo = new JMenuItem("↩");
        sUndo.addActionListener(this);
        sUndo.setActionCommand("sUndo");
        symbolBar.add(sUndo);

        sRedo = new JMenuItem("↪");
        sRedo.addActionListener(this);
        sRedo.setActionCommand("sRedo");
        symbolBar.add(sRedo);

        sFind = new JMenuItem("\uD83D\uDD0D");
        sFind.addActionListener(this);
        sFind.setActionCommand("sFind");
        symbolBar.add(sFind);

        sFull = new JMenuItem("⤨");
        sFull.addActionListener(this);
        sFull.setActionCommand("sFull");
        symbolBar.add(sFull);


    }

    public void createFileMenu(){
        iNew = new JMenuItem("New          Ctrl+N");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");//string value will trigger the action listener on this item
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open        Ctrl+O");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save          Ctrl+S");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As     Shift+Ctrl+S");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit           Shift+Ctrl+X");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap : Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("WordWrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iArialBlack = new JMenuItem("Arial Black");
        iArialBlack.addActionListener(this);
        iArialBlack.setActionCommand("Arial Black");
        menuFont.add(iArialBlack);
        iFontSansRoman = new JMenuItem("Comic Sans MS");
        iFontSansRoman.addActionListener(this);
        iFontSansRoman.setActionCommand("Comic Sans MS");
        menuFont.add(iFontSansRoman);
        iCourierNew = new JMenuItem("Courier New");
        iCourierNew.addActionListener(this);
        iCourierNew.setActionCommand("Courier New");
        menuFont.add(iCourierNew);
        iHelvetica = new JMenuItem("Helvetica");
        iHelvetica.addActionListener(this);
        iHelvetica.setActionCommand("Helvetica");
        menuFont.add(iHelvetica);
        iImpact = new JMenuItem("Impact");
        iImpact.addActionListener(this);
        iImpact.setActionCommand("Impact");
        menuFont.add(iImpact);

        iTahoma = new JMenuItem("Tahoma");
        iTahoma.addActionListener(this);
        iTahoma.setActionCommand("Tahoma");
        menuFont.add(iTahoma);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        iFontSize8 = new JMenuItem("8pt");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12pt");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16pt");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20pt");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24pt");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28pt");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menuFontSize.add(iFontSize28);
    }

    public void createColormenu(){
        iTextColor = new JMenu("Text Color");
        menuColor.add(iTextColor);
        iBkgdColor = new JMenu("Background Color");
        menuColor.add(iBkgdColor);

        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        iBkgdColor.add(iColor1);
        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        iBkgdColor.add(iColor2);
        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        iBkgdColor.add(iColor3);
        iColor4 = new JMenuItem("Peach");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Peach");
        iBkgdColor.add(iColor4);
        iColor5 = new JMenuItem("Yellow");
        iColor5.addActionListener(this);
        iColor5.setActionCommand("Yellow");
        iBkgdColor.add(iColor5);

        iiColor1 = new JMenuItem("White");
        iiColor1.addActionListener(this);
        iiColor1.setActionCommand("tWhite");
        iTextColor.add(iiColor1);
        iiColor2 = new JMenuItem("Black");
        iiColor2.addActionListener(this);
        iiColor2.setActionCommand("tBlack");
        iTextColor.add(iiColor2);
        iiColor3 = new JMenuItem("Blue");
        iiColor3.addActionListener(this);
        iiColor3.setActionCommand("tBlue");
        iTextColor.add(iiColor3);
        iiColor4 = new JMenuItem("Peach");
        iiColor4.addActionListener(this);
        iiColor4.setActionCommand("tPeach");
        iTextColor.add(iiColor4);
        iiColor5 = new JMenuItem("Yellow");
        iiColor5.addActionListener(this);
        iiColor5.setActionCommand("tYellow");
        iTextColor.add(iiColor5);
    }
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo                        Ctrl+Z");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);
        iRedo = new JMenuItem("Redo                        Ctrl+R");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

        iCopy = new JMenuItem("Copy                        Ctrl+C");
        iCopy.addActionListener(this);
        iCopy.setActionCommand("Copy");
        menuEdit.add(iCopy);

        iPaste = new JMenuItem("Paste                        Ctrl+V");
        iPaste.addActionListener(this);
        iPaste.setActionCommand("Paste");
        menuEdit.add(iPaste);
        iCut = new JMenuItem("Cut                           Ctrl+X");
        iCut.addActionListener(this);
        iCut.setActionCommand("Cut");
        menuEdit.add(iCut);

        iFind = new JMenuItem("Find                         Ctrl+F");
        iFind.addActionListener(this);
        iFind.setActionCommand("Find");
        menuEdit.add(iFind);

        iFindAndReplace = new JMenuItem("Find and replace    Ctrl+W");
        iFindAndReplace.addActionListener(this);
        iFindAndReplace.setActionCommand("Find and replace");
        menuEdit.add(iFindAndReplace);
    }

    public void createInsertMenu(){
        isc = new JMenuItem("£ Special Characters");
        isc.addActionListener(this);
        isc.setActionCommand("isc");
        menuInsert.add(isc);

        dandt = new JMenuItem("Date and Time");
        dandt.addActionListener(this);
        dandt.setActionCommand("dandt");
        menuInsert.add(dandt);

    }

    public void createViewMenu(){
        ifullscreen = new JMenuItem("Full screen");
        ifullscreen.addActionListener(this);
        ifullscreen.setActionCommand("fulls");
        menuView.add(ifullscreen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New": file.newFile(); break;
            case "sNew": file.newFile(); break;
            case "Open" : file.open(); break;
            case "sOpen" : file.open(); break;
            case "SaveAs" : file.saveAs(); break;
            case "Save" : file.save(); break;
            case "sSave" : file.save(); break;
            case "Exit" : file.exit(); break;
            case "WordWrap" : fformat.wordWrap(); break;
            case "Arial": fformat.setFont("Arial"); break;
            case "Arial Black": fformat.setFont("Arial Black"); break;
            case "Courier New": fformat.setFont("Courier New"); break;
            case "Helvetica": fformat.setFont("Helvetica"); break;
            case "Impact": fformat.setFont("Impact"); break;
            case "Tahoma": fformat.setFont("Tahoma"); break;
            case "TNR" : fformat.setFont("Times New Roman"); break;
            case "Comic Sans MS": fformat.setFont("Comic Sans MS"); break;
            case "8":fformat.createFont(8); break;
            case "12":fformat.createFont(12);break;
            case "16":fformat.createFont(16);break;
            case "20":fformat.createFont(20);break;
            case "24":fformat.createFont(24);break;
            case "28" :fformat.createFont(28);break;
            case "White" : fcolor.changeColor("White"); break;
            case "Black" : fcolor.changeColor("Black"); break;
            case "Blue" : fcolor.changeColor("Blue"); break;
            case "Peach" : fcolor.changeColor("Peach"); break;
            case "Yellow" : fcolor.changeColor("Yellow");break;
            case "tWhite" : fcolor.changetextColor("White"); break;
            case "tBlack" : fcolor.changetextColor("Black"); break;
            case "tBlue" : fcolor.changetextColor("Blue"); break;
            case "tPeach" : fcolor.changetextColor("Peach"); break;
            case "tYellow" : fcolor.changetextColor("Yellow");break;
            case "Undo" : fedit.undo(); break;
            case "sUndo" : fedit.undo(); break;
            case "Redo" : fedit.redo(); break;
            case "sRedo" : fedit.redo(); break;
            case "Copy" : fedit.copy(); break;
            case "sCopy" : fedit.copy(); break;
            case "Paste" : fedit.paste();break;
            case "sPaste" : fedit.paste();break;
            case "Cut":fedit.cut(); break;
            case "sCut":fedit.cut(); break;
            case "Find" : fedit.createFindDialog(); break;
            case "sFind" : fedit.createFindDialog(); break;
            case "Find and replace" : fedit.createFindAndReplaceDialog(); break;
            case "sFull" : fformat.fullScreen(); break;
            case "fulls" : fformat.fullScreen(); break;
            case "isc" : finsert.specialCWindow(); break;
            case "dandt" : finsert.dateAndTime(); break;


        }
    }
}

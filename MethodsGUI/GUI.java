import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*; //needed for  JFrame, JPanel, JLabel, etc.

import javax.swing.event.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
/**
 *  Class GUI
 *  Creates a graphical user interface skeleton for running methods
 *  
 * @author Beckwith
 * @version 2.0
 */
public class GUI extends JFrame implements ActionListener, FocusListener
{
    int selectedTask = 0;

    String[] taskNames;             //to be used in combobox for selections
    Tasks tasks = new Tasks();      //WHERE STUDENT METHODS WILL BE WRITTEN
    GUIinteractions interactions = new GUIinteractions();  //WHERE STUDENTS SET UP USER INTERFACE
    JComboBox<String> taskSelector;  //pull down menu to select task

    //Panels are set up to hold other things and can be placed within the MasterPanel
    JPanel masterPanel;         //panel for all components of the display
    JPanel topPanel;            //this panel holds the buttonPanel and instructionsPanel
    JPanel buttonPanel;         //panel for the submit and quit buttons 
    JPanel instructionsPanel;   //panel for JLabel with instructions to user
    JPanel ioPanel;             //panel to hold both input and report output
    JPanel reportPanel;         //panel for JLabel for reporting on the text analysis
    JPanel entryPanel;          //panel for entry boxes
    JButton quitButton, submitButton, colorButton;
    JLabel instructions;        //label for instructions to user
    JTextArea report;           //area to show all results of analysis
    JScrollPane outputScroll;
    JTextField[] entry;         //user input entry fields


    /**
     * GUI constructor
     */
    public GUI(String title)
    {
        masterPanel = (JPanel) this.getContentPane();  //master panel IS the whole window
        masterPanel.setLayout(new BorderLayout());
        /*
         * SET UP BUTTON PANEL:
         */
        //SUBMIT button: user clicks when ready to analyze text
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setActionCommand("submitButton"); 

        //quit button
        quitButton = new JButton("QUIT");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quitButton");  

        //color button
        colorButton = new JButton("Color");
        colorButton.addActionListener(this);
        colorButton.setActionCommand("colorButton");

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)));

        /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * TO ADD NEW METHODS, PUT THEIR NAMES IN taksList below:
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */
        //create tasks selector pull-down menu    
        String[] taskList ={"Select:", "Combine/Reverse Strings", "Calculate Winner"};  //list of names of tasks to show to user

        taskSelector = new JComboBox<String>(taskList);   //create the pull-down menu object
        taskSelector.setSelectedIndex(0);                 //sets which one is selected by default
        taskSelector.addActionListener(this);             //this means we can react when a different one is selected
        taskSelector.setActionCommand("taskSelector");    //the command we reacdt to

        /*
         * SET UP ALL OTHER PANELS
         */
        //INSTRUCTIONS PANEL
        instructionsPanel = new JPanel();
        instructionsPanel.setBackground(new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)));
        instructions = new JLabel("Overall instructions or any other message can go here");
        //set font and color of small instructions panel
        instructions.setForeground(Color.blue);
        Font font = new Font("Verdana", Font.BOLD, 12);
        instructions.setFont(font);
        instructionsPanel.add(instructions);   //put the JLabel into the panel

        //top panel holds buttons and instructions
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1));
        topPanel.add(buttonPanel);
        topPanel.add(instructionsPanel);

        //Here's where some instructions are and where report will be shown
        report = new JTextArea("hello.  this area will be the instructions, then report", 
            20 ,  //height in characters
            50);  //width in characters

        report.setForeground(Color.red);
        Font font2 = new Font("Verdana", Font.BOLD, 18);
        report.setFont(font2);

        report.setEditable(false);
        report.setLineWrap(true);
        report.setWrapStyleWord(true);
        //add the report to a scroll pane, so if it gets big, it will scroll:
        outputScroll = new JScrollPane(report);
        //add the scroll pane to the overall panel:
        reportPanel = new JPanel();
        reportPanel.add(outputScroll);

        /*
         * SET UP TEXTFields FOR USER INPUT:
         */
        
        //make the array of textfields (CHANGE FROM 3 to GET MORE ENTRY BOXES!!!!!!!!)
        entry = new JTextField[3]; 
        //make the actual entry boxes, with default width:
        for(int i = 0; i < entry.length; i++)
            entry[i] = new JTextField("", 20);   //20 is the number of characters width
            
        //can give default text for a box:
        entry[0].setText("(say something here?)");  
 
        //NOT ESSENTIAL: needed to delete text when entry is clicked on
        for(int i = 0; i < entry.length; i++)
            entry[i].addFocusListener(this);

        //add the menu and three buttons to the button panel:
        buttonPanel.add(taskSelector);  
        buttonPanel.add(submitButton);  
        buttonPanel.add(quitButton);
        buttonPanel.add(colorButton);

        //
        entryPanel = new JPanel();
        for(int i = 0; i < entry.length; i++)
            entryPanel.add(entry[i]);

        
        //make a panel to add entry boxes and report to:
        ioPanel = new JPanel(new BorderLayout());
        ioPanel.add(entryPanel, BorderLayout.NORTH);
        ioPanel.add(reportPanel, BorderLayout.CENTER);
        ioPanel.setBackground(Color.BLACK);
        /*
         * Put the two panels into the master panel, i.e. the whole window:
         */
        masterPanel.add(topPanel, BorderLayout.NORTH);
        masterPanel.add(ioPanel, BorderLayout.CENTER);

        /* 
         * Wrap-up: set title and size of window and set to be visible in the JFrame
         */
        this.setTitle(title);    
        this.setSize(1000, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Actionperformed: when a button is pressed, this is automatically called:
     */
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if(e.getActionCommand().equals("taskSelector"))
        {
            selectedTask = taskSelector.getSelectedIndex();  
            //show instructions for selected task:
            interactions.showIntructions(selectedTask, report, entry);

        }
        //SUBMIT BUTTON CLICKED:

        else if(e.getActionCommand().equals("submitButton"))
        {
            //uses student methods to process inputs and show results:
            interactions.getAndShowResults(tasks, selectedTask, report, 
                entry);
        }
        //QUIT BUTTON CLICKED:
        else if(e.getActionCommand().equals("quitButton")) 
        {

            JOptionPane.showMessageDialog(null,"HAVE A NICE DAY", "End of Thing",
                JOptionPane.PLAIN_MESSAGE, null);    
            System.exit(0);
        }
        else if(e.getActionCommand().equals("colorButton"))
        {
            buttonPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256))
            );
            instructionsPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)));
            ioPanel.setBackground(new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)));
        }
        //YOU COULD ALSO MAKE A "CLEAR" BUTTON.  WHEN CLICKED, IT WOULD CLEAR THE REPORT AND/OR ENTERED TEXT
        //  LOOK EVERYWHERE THERE WAS A SUBMIT BUTTON, COPY AND PASTE TO DO THE SAME WITH A CLEAR BUTTON
    }

    //NOT ESSENTIAL: needed to delete text when entry is clicked on
    @Override
    public void focusGained(FocusEvent e) 
    {
        for(int i = 0; i < entry.length; i++)
            if(entry[i].isFocusOwner()) entry[i].setText("");
    }

    public void focusLost(FocusEvent e) 
    {
        //if(entry1.isFocusOwner()) System.out.println(entry1 + "selected");
    }

}


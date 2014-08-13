package test.app;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.zip.*;

import javax.swing.*;

public class JavaZipBrowser extends JFrame {

	private static final long serialVersionUID = 4797561711688190444L;
	
    /**
	 * file chooser
	 */
	JFileChooser fileChooser;

    // absolute path of a Zip file 
    JTextField jtfTarget;

    // selection button
    JButton jbSelected;

    // result display
    JTextArea jtaInfo;

 

    public JavaZipBrowser() {

       super("zip压缩包查看程序");

       // initiating jframe
       fileChooser = new JFileChooser();
       jtfTarget = new JTextField(18);
       jbSelected = new JButton("选择");
       jtaInfo = new JTextArea();

       // initiating jpanel
       JPanel panel = new JPanel();
       panel.add(new JLabel("目标文件"));

       // adding component to the panel
       panel.add(jtfTarget);
       panel.add(jbSelected);
       JScrollPane jsp = new JScrollPane(jtaInfo);

       // set the border of the scroll panel
       jsp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       // get the container of the Content
       Container container = getContentPane();

       // adding the component to the container of the Content
       container.add(panel, BorderLayout.NORTH);
       container.add(jsp, BorderLayout.CENTER);


       // the event listener of selection button 
       jbSelected.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
              // popup the file chooser 
              if (fileChooser.showOpenDialog(JavaZipBrowser.this) == JFileChooser.APPROVE_OPTION) {
                  // get the obsolute path of the file
                  String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                  // set the target file
                  jtfTarget.setText(fileName);
                  // show the file contents
                  showFileInfo();
              }
           }
       });

       // zip button event listener
       jtfTarget.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   //show the file contents
              showFileInfo();
           }
       });
       setSize(350, 250);
       setVisible(true);
       // quite the main program
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 

    // show the file contents
    public void showFileInfo() {
       try {
           // show the file name;file size;created time
           jtaInfo.append("文件名\t文件大小\t创建日期\n");

           // initiating the Zipfile object
           ZipFile zfile = new ZipFile(jtfTarget.getText());
           ZipEntry entry;
           // get the zip Enumeration
           Enumeration<? extends ZipEntry> enu = zfile.entries();
           // loop the Enumeration
           while (enu.hasMoreElements()) {
              // get the each entry of the Enumeration
              entry = (ZipEntry) enu.nextElement();
              // show the info of each entry
              jtaInfo.append(entry.getName() + "\t");
              jtaInfo.append(entry.getSize() + "\t");
              jtaInfo.append(new Date(entry.getTime()) + "\n");
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
    }
}
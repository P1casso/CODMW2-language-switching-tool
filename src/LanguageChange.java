/**
 * @author p1ca2so
 * @version 1.0
 * @date 2021/7/25 23:56
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class LanguageChange extends JFrame {

    private final JPanel contentPane;

    public LanguageChange() {

        setTitle("使命召唤6-现代战争2重制版 ExternV3语言切换工具");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //点击右上角×的时候删除配置文件，擦屁股
        addWindowListener(new WindowAdapter() {
                              @Override
                              public void windowClosing(WindowEvent e) {
                                  File file = new File("C:\\Temporary documents");
                                  if (!file.exists()) {
                                      System.exit(0);
                                  } else {
                                      delectFolder(file);
                                      if (file.exists()) {
                                          JOptionPane.showMessageDialog(null, "Unknown mistake,please try again", "error", 0);
                                      }
                                  }
                              }
                          }
        );

        setBounds(100, 100, 466, 262);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        /**
         * combobox按钮
         **/
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"English", "中文"}));
        comboBox.setBounds(209, 51, 110, 23);
        contentPane.add(comboBox);

        JLabel lblNewLabel = new JLabel("language：");
        lblNewLabel.setBounds(142, 51, 74, 23);
        contentPane.add(lblNewLabel);

        // 退出按钮
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(123, 131, 93, 23);
        // 按钮监听事件,按钮点击时退出软件,并删除1配置文件，擦屁股
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("C:\\Temporary Files");
                if (!file.exists()) {
                    System.exit(0);
                } else {
                    delectFolder(file);
                    if (file.exists()) {
                        JOptionPane.showMessageDialog(null, "Unknown mistake,please try again", "error", 0);
                    }
                }
            }
        });

        contentPane.add(quitButton);

        JButton confirmButton = new JButton("confirm");
        confirmButton.setBounds(254, 131, 93, 23);
        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 读取comboBox的内容
                String language = comboBox.getSelectedItem().toString();
                String cmdhead = "Windows Registry Editor Version 5.00\r\n" + "\r\n"
                        + "[HKEY_CURRENT_USER\\Software\\Blizzard Entertainment]\r\n" + "\r\n"
                        + "[HKEY_CURRENT_USER\\Software\\Blizzard Entertainment\\Battle.net]\r\n" + "\r\n"
                        + "[HKEY_CURRENT_USER\\Software\\Blizzard Entertainment\\Battle.net\\Launch Options]\r\n"
                        + "\r\n"
                        + "[HKEY_CURRENT_USER\\Software\\Blizzard Entertainment\\Battle.net\\Launch Options\\LAZR]\r\n";

                if (language == "English") {
                    String cmdtail = "\"LOCALE\"=\"enUS\"\r\n" + "\"LOCALE_AUDIO\"=\"enUS\"";
                    String cmd = cmdhead + cmdtail;
                    String url = "C:\\Temporary documents\\English.reg";
                    File floder = new File("C:\\Temporary documents");
                    if (!floder.exists()) {
                        floder.mkdir();
                    }
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter(url);
                        fileWriter.write(cmd);
                        fileWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    File file = new File(url);
                    try {
                        java.awt.Desktop.getDesktop().open(file);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {

                    }

                } else if (language == "中文") {
                    String cmdtail = "\"LOCALE\"=\"zhCN\"\r\n" + "\"LOCALE_AUDIO\"=\"zhCN\"";
                    String cmd = cmdhead + cmdtail;
                    String url = "C:\\Temporary documents\\Chinese.reg";
                    File floder = new File("C:\\Temporary documents");
                    if (!floder.exists()) {
                        floder.mkdir();

                    }
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter(url);
                        fileWriter.write(cmd);
                        fileWriter.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    File file = new File(url);
                    try {
                        java.awt.Desktop.getDesktop().open(file);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {

                    }

                }

            }
        });
        contentPane.add(confirmButton);

        //声明
        JLabel lblNewLabel_1 = new JLabel("author：p1ca2so \r\nFor learning and communication use only");
        lblNewLabel_1.setBounds(52, 181, 344, 15);
        contentPane.add(lblNewLabel_1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LanguageChange frame = new LanguageChange();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    /**
     * 删除文件方法，擦屁股
     **/
    public static void delectFolder(File file) {
        // 读取文件列表
        File[] files = file.listFiles();
        if (file != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delectFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        file.delete();
        System.exit(0);
    }
}

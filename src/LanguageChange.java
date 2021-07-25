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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

public class LanguageChange extends JFrame {

    private final JPanel contentPane;

    public LanguageChange() {
        setTitle("\u4F7F\u547D\u53EC\u55246-\u73B0\u4EE3\u6218\u4E892\u91CD\u5236\u7248 ExternV3\u8BED\u8A00\u5207\u6362\u5DE5\u5177");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Code\\Eclipse\\language_change\\icon\\1.ico"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 466, 262);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"English", "\u4E2D\u6587"}));
        comboBox.setBounds(209, 51, 110, 23);
        contentPane.add(comboBox);

        // comboBox监听事件
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                int index = comboBox.getSelectedIndex();
                if (e.getStateChange() == ItemEvent.SELECTED) {
//					ItemListener类中的方法itemStateChanged()事件的itemState有关，
//					itemState在这里的状态有两个，Selected 和 deSelected（即选中和未被选中）
                    System.out.println(comboBox.getSelectedItem().toString());

                }

            }
        });

        JLabel lblNewLabel = new JLabel("language\uFF1A");
        lblNewLabel.setBounds(142, 51, 74, 23);
        contentPane.add(lblNewLabel);

        JButton quitButton = new JButton("quit");// 退出按钮
        quitButton.setBounds(123, 131, 93, 23);// 按钮位置
        // 按钮监听事件
        // 按钮点击时退出软件
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 退出
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
                if (language == "English") {
                    File file = new File("./_Language Switcher\\English.reg");
                    try {
                        java.awt.Desktop.getDesktop().open(file);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Unknown mistake,please try again", "error", 0);
                    } catch (IllegalArgumentException e2) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "Please put this software in the game root directory", "error", 0);
                    }

                } else if (language == "中文") {
                    File file = new File("./_Language Switcher\\Simplified Chinese.reg");
                    try {
                        java.awt.Desktop.getDesktop().open(file);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        System.out.println("fall");
                        JOptionPane.showMessageDialog(null, "Unknown mistake,please try again", "error", 0);
                    } catch (IllegalArgumentException e2) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "Please put this software in the game root directory", "error", 0);
                    }


                }

            }
        });
        contentPane.add(confirmButton);

        JLabel lblNewLabel_1 = new JLabel("author\uFF1Ap1ca2so \r\nFor learning and communication use only");
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
}

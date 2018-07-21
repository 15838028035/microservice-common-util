package com.zhongkexinli.micro.serv.common.security;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * DES工具类
 *
 */
public class DesUtilFrame extends JFrame implements ActionListener {

  private static Log logger = LogFactory.getLog(DesUtilFrame.class);
  
  /**
   * 标题
   */
  private JLabel titleInformation;
  private JLabel fileName;

  /**
   * fileNameTextField
   */
  private JTextField fileNameTextField;
  private JButton submit;

  private JTextArea result;

  GridBagLayout g = new GridBagLayout();

  GridBagConstraints c = new GridBagConstraints();

  DesUtilFrame(String str) {
    super(str);

    setSize(800, 600);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(g);
    // 调用方法

    addComponent();

    submit.addActionListener(this);

    setVisible(true);

    setLocationRelativeTo(null);// 设居中显示;

  }

  /**
   * 添加组件
   */
  public void addComponent() {
    titleInformation = new JLabel("des3解密工具");

    add(g, c, titleInformation, 0, 0, 1, 1);

    fileName = new JLabel("密文：");

    add(g, c, fileName, 0, 1, 1, 1);

    fileNameTextField = new JTextField(50);

    add(g, c, fileNameTextField, 1, 1, 1, 1);

    submit = new JButton("解密");

    c.insets = new Insets(8, 10, 4, 0);

    add(g, c, submit, 1, 6, 1, 1);

    result = new JTextArea(15, 50);

    add(g, c, result, 0, 7, 3, 4);

  }

  /**
   * 添加布局
   * @param g 布局对象
   * @param c 布局容器
   * @param jc 布局组件
   * @param x x
   * @param y y
   * @param gw 宽度
   * @param gh 高度
   */
  public void add(GridBagLayout g, GridBagConstraints c, JComponent jc, int x, int y, int gw, int gh) {

    c.gridx = x;

    c.gridy = y;

    c.anchor = GridBagConstraints.WEST;

    c.gridwidth = gw;

    c.gridheight = gh;

    g.setConstraints(jc, c);

    add(jc);

  }

  /**
   * main
   * @param args 参数
   */
  public static void main(String [] args) {
    new DesUtilFrame("des3解密工具");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    String fileNameTextFieldStr = fileNameTextField.getText();

    String retMsg = "";

    try {

      retMsg = DesUtil.decrypt(fileNameTextFieldStr);
    } catch (Exception e) {
      logger.error(e);
      retMsg = "解密失败" + ",异常信息:" + e.getMessage();
    }

    result.setText(retMsg);

  }
}
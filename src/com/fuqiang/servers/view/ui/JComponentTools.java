
package com.fuqiang.servers.view.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Administrator
 */
public class JComponentTools {
    /**
     * 设置jframe窗口的居中
     * @param jframe 
     */
    public static void setFrameCenter(JFrame jframe){
        //使用工具获得屏幕的像素
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //获取程序的宽度
        Dimension jfram = jframe.getSize();
        int newX = (int)(screenSize.getWidth()-jfram.getWidth())/2;
        int newY = (int)(screenSize.getHeight()-jfram.getHeight())/2;
        
        jframe.setLocation(newX, newY);
        
    }
    //设置文本类的重置
    public static void setJTextFieldReset(JTextComponent jtf){
        jtf.setText("");
        jtf.requestFocus();
    }
    
}

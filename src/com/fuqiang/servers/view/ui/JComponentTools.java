
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
     * ����jframe���ڵľ���
     * @param jframe 
     */
    public static void setFrameCenter(JFrame jframe){
        //ʹ�ù��߻����Ļ������
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //��ȡ����Ŀ��
        Dimension jfram = jframe.getSize();
        int newX = (int)(screenSize.getWidth()-jfram.getWidth())/2;
        int newY = (int)(screenSize.getHeight()-jfram.getHeight())/2;
        
        jframe.setLocation(newX, newY);
        
    }
    //�����ı��������
    public static void setJTextFieldReset(JTextComponent jtf){
        jtf.setText("");
        jtf.requestFocus();
    }
    
}

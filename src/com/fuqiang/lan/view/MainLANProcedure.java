
package com.fuqiang.lan.view;



import com.fuqiang.lan.view.ui.login.LoginJFrame;

/**
 *�������е�������
 * @author Administrator
 */
public class MainLANProcedure {
	public static boolean login;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        openProgram();
    }
    //�򿪳���ķ���
    public static void openProgram(){
    	
    	LoginJFrame main = new LoginJFrame();
    	main.setVisible(true);
    }
    
}

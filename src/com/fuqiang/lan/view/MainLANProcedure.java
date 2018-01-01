
package com.fuqiang.lan.view;



import com.fuqiang.lan.view.ui.login.LoginJFrame;

/**
 *程序运行的主界面
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
    //打开程序的方法
    public static void openProgram(){
    	
    	LoginJFrame main = new LoginJFrame();
    	main.setVisible(true);
    }
    
}

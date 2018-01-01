
package com.fuqiang.lan.view.ui.login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.fuqiang.lan.cm.client.Client;
import com.fuqiang.lan.cm.send.Send;
import com.fuqiang.lan.cm.tools.ReceiveTools;
import com.fuqiang.lan.view.ui.JComponentTools;
import com.fuqiang.lan.view.ui.UsersJFrame;
import com.fuqiang.lan.view.ui.register.RegisterJFrame;

/**
 *
 * @author Administrator
 */
public class LoginJFrame extends JFrame {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginJFrame() {
        initComponents();
        init();
    }
    public final void init(){
        //设置屏幕剧中
        JComponentTools.setFrameCenter(this);
    } 
	//基本的属性设置
    private void initComponents() {
        userNamejLable = new  JLabel();
        userNamejTextField = new  JTextField();
        userPassordJLabel = new  JLabel();
        userPasswordJPasswordField = new  JPasswordField();
        easytop = new  JLabel();
        logInJButton = new  JButton();
        registerJButton = new  JButton();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        userNamejLable.setFont(new Font("微软雅黑", 0, 14)); // NOI18N
        userNamejLable.setText("用户名 ：");

        userNamejTextField.setToolTipText("");

        userPassordJLabel.setFont(new Font("微软雅黑", 0, 14)); // NOI18N
        userPassordJLabel.setText("密     码：");

        easytop.setFont(new Font("楷体", 0, 24)); // NOI18N
        easytop.setText("易  通");

        logInJButton.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
        logInJButton.setText("登录");
        logInJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logInJButtonActionPerformed(evt);
            }
        });

        registerJButton.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
        registerJButton.setText("注册");
        registerJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                            .addComponent(userPassordJLabel,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userNamejLable,  GroupLayout.PREFERRED_SIZE, 72,  GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(easytop,  GroupLayout.PREFERRED_SIZE, 109,  GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userNamejTextField)
                                    .addComponent(userPasswordJPasswordField,  GroupLayout.PREFERRED_SIZE, 190,  GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(logInJButton,  GroupLayout.PREFERRED_SIZE, 110,  GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(registerJButton,  GroupLayout.PREFERRED_SIZE, 110,  GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(easytop,  GroupLayout.PREFERRED_SIZE, 37,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(userNamejLable,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNamejTextField,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassordJLabel,  GroupLayout.PREFERRED_SIZE, 27,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(userPasswordJPasswordField,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(registerJButton)
                    .addComponent(logInJButton))
                .addGap(20, 20, 20))
        );

        pack();
    }
   //登录按钮的事件设置
    private void logInJButtonActionPerformed(ActionEvent evt) {
        String userName = userNamejTextField.getText();
        String userPassword = new String(userPasswordJPasswordField.getPassword());
        if(userName.equals("")){
            JOptionPane.showMessageDialog(userNamejTextField,"用户名不能为空！"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(userPassword.equals("")){
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"密码不能为空！"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(!userName.matches(".{2,12}")){
            JOptionPane.showMessageDialog(userNamejTextField,"用户名不能小于两位  不能大于12位！"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(!userPassword.matches("\\w{5,13}")){
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"密码必须为5-12位字母、数字或下划线的组合"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        //获取登录的对象信息
        String requestLoginUser = "@userLogin#"+userName+"&"+userPassword;
       Client client = new Client(userName);
        //此处插入返回的信息进行判断是否可以登录
        boolean register  = ReceiveTools.returnLogin(client.request(requestLoginUser));//将判断在此处判断
        
        //判断登录信息
        if(register){
           //登录成功可进入主界面
            JOptionPane.showMessageDialog(this,"登陆成功！"); 
			ReceiveTools.returnUserList(client.request("@userList"));
            UsersJFrame userList = new UsersJFrame(userName,client);
            UsersJFrame.users.put(userName,userList);
            this.dispose();
            userList.setVisible(true);
            
    		 
        }else{
            //提示登录信息错误
        	
            JOptionPane.showMessageDialog(this,"用户名或密码错误！"); 
            client.close();
            //重置所有
             resetAll();
        }
        
    }
    public void resetAll(){
        JComponentTools.setJTextFieldReset(userNamejTextField);
        JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
    }
//登录界面注册按钮
    private void registerJButtonActionPerformed(ActionEvent evt) {
       //创建注册按钮
        RegisterJFrame register = new RegisterJFrame();
        //使该界面显示
        register.setVisible(true);
        //将登录界面关闭
        this.dispose();
    }


    private  JLabel easytop;
    private  JButton logInJButton;
    private  JButton registerJButton;
    private  JLabel userNamejLable;
    private  JTextField userNamejTextField;
    private  JLabel userPassordJLabel;
    private  JPasswordField userPasswordJPasswordField;

}

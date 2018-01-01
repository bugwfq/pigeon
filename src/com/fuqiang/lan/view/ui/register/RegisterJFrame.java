
package com.fuqiang.lan.view.ui.register;

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
import com.fuqiang.lan.cm.tools.ReceiveTools;
import com.fuqiang.lan.view.ui.JComponentTools;
import com.fuqiang.lan.view.ui.entity.User;
import com.fuqiang.lan.view.ui.login.LoginJFrame;

/**
 *
 * @author Administrator
 */
public class RegisterJFrame extends  JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RegisterJFrame() {
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
        registerJButton = new  JButton();
        resetjButton = new  JButton();
        backJButton = new  JButton();
        userPassord2JLabel = new  JLabel();
        userPassword2JPasswordField = new  JPasswordField();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        userNamejLable.setFont(new Font("微软雅黑", 0, 14)); // NOI18N
        userNamejLable.setText("用户名  ：");

        userNamejTextField.setToolTipText("");

        userPassordJLabel.setFont(new Font("微软雅黑", 0, 14)); // NOI18N
        userPassordJLabel.setText("密      码：");

        easytop.setFont(new Font("楷体", 0, 24)); // NOI18N
        easytop.setText("注    册");

        registerJButton.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
        registerJButton.setText("注册");
        registerJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });

        resetjButton.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
        resetjButton.setText("重置");
        resetjButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
        backJButton.setText("返回");
        backJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        userPassord2JLabel.setFont(new Font("微软雅黑", 0, 14)); // NOI18N
        userPassord2JLabel.setText("确认密码：");

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(registerJButton,  GroupLayout.PREFERRED_SIZE, 110,  GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(resetjButton,  GroupLayout.PREFERRED_SIZE, 102,  GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton,  GroupLayout.PREFERRED_SIZE, 100,  GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                    .addComponent(userPassord2JLabel,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPassordJLabel,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNamejLable,  GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(easytop,  GroupLayout.PREFERRED_SIZE, 109,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addComponent(userPassword2JPasswordField,  GroupLayout.PREFERRED_SIZE, 190,  GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                .addComponent(userNamejTextField)
                                .addComponent(userPasswordJPasswordField,  GroupLayout.PREFERRED_SIZE, 190,  GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                    .addComponent(userPassord2JLabel,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPassword2JPasswordField,  GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                    .addComponent(backJButton,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerJButton,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetjButton))
                .addGap(29, 29, 29))
        );

        pack();
    }
    //注册界面注册按钮
    private void registerJButtonActionPerformed(ActionEvent evt) {
       String userName = userNamejTextField.getText();
       String userPassword = new String(userPasswordJPasswordField.getPassword());
       String userPassword2 = new String(userPassword2JPasswordField.getPassword());
        if(userName.equals("")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userNamejTextField,"用户名不能为空！"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(userPassword.equals("")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"密码不能为空！"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(userPassword2.equals("")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userPassword2JPasswordField,"密码不能为空！"); 
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return ;
        }
        if(!userName.matches(".{2,13}")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userNamejTextField,"用户名必须为2-12位汉子、字母、数字或下划线的组合"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(!userPassword.matches("\\w{5,13}")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"密码必须为5-12位字母、数字或下划线的组合"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(!userPassword2.matches("\\w{5,13}")){
            //弹出错误提示框
            JOptionPane.showMessageDialog(userPassword2JPasswordField,"密码必须为5-12位字母、数字或下划线的组合"); 
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return ;
        }
        if(!userPassword.equals(userPassword2)){
            //弹出错误提示框
             JOptionPane.showMessageDialog(userPassword2JPasswordField,"两次密码不一致"); 
             
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return;
        }
      //获取登录的对象信息
        String request = "@userRegister#"+userName+"&"+userPassword;
        Client client  = new Client(userName);
        //此处插入返回的信息进行判断是否注册成功！
        boolean register  = ReceiveTools.returnLogin(client.request(request));//将判断在此处判断
        //此处插入返回的信息进行判断是
        if(register){
        	
            JOptionPane.showMessageDialog(this,"注册成功请登录！！"); 
            backLogin();
           client.close();
        }else{
            JOptionPane.showMessageDialog(this,"该账号已存在"); 
            client.close();
            //重置所有
             resetAll();
        }
    }

    private void resetJButtonActionPerformed(ActionEvent evt) {
       resetAll();
    }
    public void resetAll(){
        JComponentTools.setJTextFieldReset(userNamejTextField);
        JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
        JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
    }
//返回登录界面
    private void backJButtonActionPerformed(ActionEvent evt) {
       backLogin();
    }
    public void backLogin(){
        //创建登录面板
        LoginJFrame login = new LoginJFrame();
        //显示面板
        login.setVisible(true);
        this.dispose();
    }


    private  JButton backJButton;
    private  JLabel easytop;
    private  JButton registerJButton;
    private  JButton resetjButton;
    private  JLabel userNamejLable;
    private  JTextField userNamejTextField;
    private  JLabel userPassord2JLabel;
    private  JLabel userPassordJLabel;
    private  JPasswordField userPassword2JPasswordField;
    private  JPasswordField userPasswordJPasswordField;

}

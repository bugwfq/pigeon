
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
        //������Ļ����
        JComponentTools.setFrameCenter(this);
    } 

   //��������������
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

        userNamejLable.setFont(new Font("΢���ź�", 0, 14)); // NOI18N
        userNamejLable.setText("�û���  ��");

        userNamejTextField.setToolTipText("");

        userPassordJLabel.setFont(new Font("΢���ź�", 0, 14)); // NOI18N
        userPassordJLabel.setText("��      �룺");

        easytop.setFont(new Font("����", 0, 24)); // NOI18N
        easytop.setText("ע    ��");

        registerJButton.setFont(new Font("΢���ź�", 1, 18)); // NOI18N
        registerJButton.setText("ע��");
        registerJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });

        resetjButton.setFont(new Font("΢���ź�", 1, 18)); // NOI18N
        resetjButton.setText("����");
        resetjButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new Font("΢���ź�", 1, 18)); // NOI18N
        backJButton.setText("����");
        backJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        userPassord2JLabel.setFont(new Font("΢���ź�", 0, 14)); // NOI18N
        userPassord2JLabel.setText("ȷ�����룺");

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
    //ע�����ע�ᰴť
    private void registerJButtonActionPerformed(ActionEvent evt) {
       String userName = userNamejTextField.getText();
       String userPassword = new String(userPasswordJPasswordField.getPassword());
       String userPassword2 = new String(userPassword2JPasswordField.getPassword());
        if(userName.equals("")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userNamejTextField,"�û�������Ϊ�գ�"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(userPassword.equals("")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"���벻��Ϊ�գ�"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(userPassword2.equals("")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userPassword2JPasswordField,"���벻��Ϊ�գ�"); 
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return ;
        }
        if(!userName.matches(".{2,13}")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userNamejTextField,"�û�������Ϊ2-12λ���ӡ���ĸ�����ֻ��»��ߵ����"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(!userPassword.matches("\\w{5,13}")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"�������Ϊ5-12λ��ĸ�����ֻ��»��ߵ����"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(!userPassword2.matches("\\w{5,13}")){
            //����������ʾ��
            JOptionPane.showMessageDialog(userPassword2JPasswordField,"�������Ϊ5-12λ��ĸ�����ֻ��»��ߵ����"); 
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return ;
        }
        if(!userPassword.equals(userPassword2)){
            //����������ʾ��
             JOptionPane.showMessageDialog(userPassword2JPasswordField,"�������벻һ��"); 
             
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            JComponentTools.setJTextFieldReset(userPassword2JPasswordField);
            return;
        }
      //��ȡ��¼�Ķ�����Ϣ
        String request = "@userRegister#"+userName+"&"+userPassword;
        Client client  = new Client(userName);
        //�˴����뷵�ص���Ϣ�����ж��Ƿ�ע��ɹ���
        boolean register  = ReceiveTools.returnLogin(client.request(request));//���ж��ڴ˴��ж�
        //�˴����뷵�ص���Ϣ�����ж���
        if(register){
        	
            JOptionPane.showMessageDialog(this,"ע��ɹ����¼����"); 
            backLogin();
           client.close();
        }else{
            JOptionPane.showMessageDialog(this,"���˺��Ѵ���"); 
            client.close();
            //��������
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
//���ص�¼����
    private void backJButtonActionPerformed(ActionEvent evt) {
       backLogin();
    }
    public void backLogin(){
        //������¼���
        LoginJFrame login = new LoginJFrame();
        //��ʾ���
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

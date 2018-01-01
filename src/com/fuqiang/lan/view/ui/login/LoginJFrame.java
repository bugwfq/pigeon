
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
        logInJButton = new  JButton();
        registerJButton = new  JButton();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        userNamejLable.setFont(new Font("΢���ź�", 0, 14)); // NOI18N
        userNamejLable.setText("�û��� ��");

        userNamejTextField.setToolTipText("");

        userPassordJLabel.setFont(new Font("΢���ź�", 0, 14)); // NOI18N
        userPassordJLabel.setText("��     �룺");

        easytop.setFont(new Font("����", 0, 24)); // NOI18N
        easytop.setText("��  ͨ");

        logInJButton.setFont(new Font("΢���ź�", 1, 18)); // NOI18N
        logInJButton.setText("��¼");
        logInJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logInJButtonActionPerformed(evt);
            }
        });

        registerJButton.setFont(new Font("΢���ź�", 1, 18)); // NOI18N
        registerJButton.setText("ע��");
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
   //��¼��ť���¼�����
    private void logInJButtonActionPerformed(ActionEvent evt) {
        String userName = userNamejTextField.getText();
        String userPassword = new String(userPasswordJPasswordField.getPassword());
        if(userName.equals("")){
            JOptionPane.showMessageDialog(userNamejTextField,"�û�������Ϊ�գ�"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(userPassword.equals("")){
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"���벻��Ϊ�գ�"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        if(!userName.matches(".{2,12}")){
            JOptionPane.showMessageDialog(userNamejTextField,"�û�������С����λ  ���ܴ���12λ��"); 
            JComponentTools.setJTextFieldReset(userNamejTextField);
            return ;
        }
        if(!userPassword.matches("\\w{5,13}")){
            JOptionPane.showMessageDialog(userPasswordJPasswordField,"�������Ϊ5-12λ��ĸ�����ֻ��»��ߵ����"); 
            JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
            return ;
        }
        //��ȡ��¼�Ķ�����Ϣ
        String requestLoginUser = "@userLogin#"+userName+"&"+userPassword;
       Client client = new Client(userName);
        //�˴����뷵�ص���Ϣ�����ж��Ƿ���Ե�¼
        boolean register  = ReceiveTools.returnLogin(client.request(requestLoginUser));//���ж��ڴ˴��ж�
        
        //�жϵ�¼��Ϣ
        if(register){
           //��¼�ɹ��ɽ���������
            JOptionPane.showMessageDialog(this,"��½�ɹ���"); 
			ReceiveTools.returnUserList(client.request("@userList"));
            UsersJFrame userList = new UsersJFrame(userName,client);
            UsersJFrame.users.put(userName,userList);
            this.dispose();
            userList.setVisible(true);
            
    		 
        }else{
            //��ʾ��¼��Ϣ����
        	
            JOptionPane.showMessageDialog(this,"�û������������"); 
            client.close();
            //��������
             resetAll();
        }
        
    }
    public void resetAll(){
        JComponentTools.setJTextFieldReset(userNamejTextField);
        JComponentTools.setJTextFieldReset(userPasswordJPasswordField);
    }
//��¼����ע�ᰴť
    private void registerJButtonActionPerformed(ActionEvent evt) {
       //����ע�ᰴť
        RegisterJFrame register = new RegisterJFrame();
        //ʹ�ý�����ʾ
        register.setVisible(true);
        //����¼����ر�
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

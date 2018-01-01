
package com.fuqiang.servers.view.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.fuqiang.servers.sm.Server;
import com.fuqiang.servers.sm.StartThread;

/**
 *
 * @author Administrator
 */
public class SocketJFrame extends JFrame {
	public static List<SocketJFrame> socketlist;
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SocketJFrame() {
		socketlist = new ArrayList<SocketJFrame>();
        initComponents();
        init();
    }
    //�ɼ������õ����
    public final void init(){
        //���ô��ھ���
        JComponentTools.setFrameCenter(this);
    }
    //���������ò���
    private void initComponents() {
        portNumJLabel = new JLabel();
        startServersJButton = new JButton();
        closeServersJButton = new JButton();
        portTextField = new JTextField();
        jScrollPane1 = new JScrollPane();
        userJList = new JList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        portNumJLabel.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        portNumJLabel.setText("�˿ں�");

        startServersJButton.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        startServersJButton.setText("����������");
        startServersJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startServersJButtonActionPerformed(evt);
            }
        });

        closeServersJButton.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        closeServersJButton.setText("�رշ�����");
        closeServersJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeServersJButtonActionPerformed(evt);
            }
        });
        //�û��б�
        setUserList();
        userJList.setFixedCellHeight(30);
        userJList.setFixedCellWidth(30);
        userJList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                userJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userJList);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(portNumJLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portTextField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startServersJButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeServersJButton))
                    .addComponent(jScrollPane1))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(portNumJLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addComponent(portTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(startServersJButton, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(closeServersJButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    //�����������İ�ť
    private void startServersJButtonActionPerformed(ActionEvent evt) {
    	 if(portTextField.getText()==null){
    		 JOptionPane.showMessageDialog(this,"�˿ںŲ���Ϊ�գ�"); 
    		 return;
    	 }
         int port = Integer.valueOf(portTextField.getText());
            if(port<1024){
            JOptionPane.showMessageDialog(this,"�˿ںű������1024��"); 
            JComponentTools.setJTextFieldReset(portTextField);
           return;
         }
         
         startServers(port);
    }//GEN-LAST:event_startServersJButtonActionPerformed
    //���Ե��õ������������ķ���
    private void startServers(int port){
    	StartThread start = new StartThread(port);
    	start.start();
        
    }
    //�رշ�����
    private void closeServersJButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_closeServersJButtonActionPerformed
        closeServers();
    }
     //���Ե��ùرշ������ķ���
    private void closeServers(){
        //�˴�������ùرշ������ķ���
    	Server.close(this);

    }
    private void userJListMouseClicked(MouseEvent evt) {
       
    }
    	//��ȡ��ǰ��½�û��б�
    public void setUserList(){
        userJList.setModel(new AbstractListModel<Object>() {
       
		private static final long serialVersionUID = 1L;
		Object[] objects = userJlistAddUsers();
		
        @Override
        public int getSize() { return objects.length; }
        @Override
        public Object getElementAt(int i) { return objects[i]; }
    });
    }
    //�����û��б�
    private Object[] userJlistAddUsers(){
        //�˴����������û����б�
    	Object[] users = Server.userList();
    	if(users.length == 0){
    		return users = new Object[]{" "};
    	}
        return users;
    }
   
    private JButton closeServersJButton;
    private JScrollPane jScrollPane1;
    private JLabel portNumJLabel;
    private JTextField portTextField;
    private JButton startServersJButton;
    private JList<Object> userJList;
}

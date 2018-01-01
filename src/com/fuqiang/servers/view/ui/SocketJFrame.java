
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
    //可加入设置的入口
    public final void init(){
        //设置窗口剧中
        JComponentTools.setFrameCenter(this);
    }
    //基本的设置布局
    private void initComponents() {
        portNumJLabel = new JLabel();
        startServersJButton = new JButton();
        closeServersJButton = new JButton();
        portTextField = new JTextField();
        jScrollPane1 = new JScrollPane();
        userJList = new JList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        portNumJLabel.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        portNumJLabel.setText("端口号");

        startServersJButton.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        startServersJButton.setText("启动服务器");
        startServersJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startServersJButtonActionPerformed(evt);
            }
        });

        closeServersJButton.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        closeServersJButton.setText("关闭服务器");
        closeServersJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeServersJButtonActionPerformed(evt);
            }
        });
        //用户列表
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
    //启动服务器的按钮
    private void startServersJButtonActionPerformed(ActionEvent evt) {
    	 if(portTextField.getText()==null){
    		 JOptionPane.showMessageDialog(this,"端口号不能为空！"); 
    		 return;
    	 }
         int port = Integer.valueOf(portTextField.getText());
            if(port<1024){
            JOptionPane.showMessageDialog(this,"端口号必须大于1024！"); 
            JComponentTools.setJTextFieldReset(portTextField);
           return;
         }
         
         startServers(port);
    }//GEN-LAST:event_startServersJButtonActionPerformed
    //可以调用的启动服务器的方法
    private void startServers(int port){
    	StartThread start = new StartThread(port);
    	start.start();
        
    }
    //关闭服务器
    private void closeServersJButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_closeServersJButtonActionPerformed
        closeServers();
    }
     //可以调用关闭服务器的方法
    private void closeServers(){
        //此处插入调用关闭服务器的方法
    	Server.close(this);

    }
    private void userJListMouseClicked(MouseEvent evt) {
       
    }
    	//获取当前登陆用户列表
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
    //返回用户列表
    private Object[] userJlistAddUsers(){
        //此处插入在线用户的列表
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

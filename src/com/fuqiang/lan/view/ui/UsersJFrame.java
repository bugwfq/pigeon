
package com.fuqiang.lan.view.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.fuqiang.lan.cm.client.Client;
import com.fuqiang.lan.cm.send.Send;
import com.fuqiang.lan.view.ui.login.userlist.UserList;

/**
 *
 * @author Administrator
 */
public class UsersJFrame extends JFrame {
	public static HashMap<String,UsersJFrame> users = new HashMap<>();
	public static boolean login;
	public String name;
	private Client client;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsersJFrame() {
        initComponents();
    }
    public UsersJFrame(String username,Client client) {
    	this.client = client;
    	client.start();
        login = true;
        initComponents();
        name = username;
        //其他设置
        setUserwsJFramLocation();
        setuserNameLogo(username);
    }
    private void setUserwsJFramLocation() {
    	 //使用工具获得屏幕的像素
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //获取程序的宽度
        Dimension jfram = this.getSize();
        double newX = (screenSize.getWidth()-jfram.getWidth())/1.1;
        double newY = (screenSize.getHeight()-jfram.getHeight())/2;
        
        this.setLocation((int)newX, (int)newY);
	}
	//对外提供的设置方法
    public final void setuserNameLogo(String name){
        userNamelogo.setText(name);
    }
    private void initComponents() {

        userNamelogo = new  JLabel();
        logo = new  JButton();
        jScrollPane1 = new  JScrollPane();
        userJList = new  JList<>();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        logo.setText("jButton1");
        ImageIcon icon=new ImageIcon("src/com/fuqiang/lan/view/ui/t017.gif"); // 读取图片作为图标
        logo=new JButton();       	// 新建按钮
        logo.setIcon(icon);			// 位按钮设置图标
        userJList.setFont(new Font("宋体", 0, 18)); // NOI18N
        setUserList();
        userJList.setFixedCellHeight(30);
        userJList.setFixedCellWidth(30);
        userJList.setVerifyInputWhenFocusTarget(false);
        userJList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                userJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userJList);

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo,  GroupLayout.PREFERRED_SIZE, 130,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNamelogo,  GroupLayout.PREFERRED_SIZE, 108,  GroupLayout.PREFERRED_SIZE)))
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo,  GroupLayout.PREFERRED_SIZE, 111,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(userNamelogo,  GroupLayout.PREFERRED_SIZE, 52,  GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 426,  GroupLayout.PREFERRED_SIZE)
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
	//获取当前登陆用户列表
	public void setUserList(){
		userJList.setModel(new  AbstractListModel<Object>() {
            /**
			 * 
			 */
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
    	//葛彪祖切分储存
    	
        Object[] users = UserList.getUser();
        return users;
    }
//列表的点击私聊
    private void userJListMouseClicked(MouseEvent evt) {//GEN-FIRST:event_userJListMouseClicked
        if(evt.getClickCount() == 2){
            JList<?> myList = (JList<?>) evt.getSource();
            int index = myList.getSelectedIndex();    //已选项的下标
            Object obj = myList.getModel().getElementAt(index);  //取出数据
            //获取点击的用户名
           
            String name = obj.toString();
            if(name.equals(UserList.obj[0].toString())){
            	ProcedureJFrame pUser= ProcedureJFrame.userListJFame.get(name);
            	if(pUser == null){
                	pUser = new ProcedureJFrame(name,this.name,client);
                	ProcedureJFrame.userListJFame.put(name, pUser);
                    pUser.setVisible(true);
                }
                pUser.setVisible(true);
            }else{
            	//在此处创建出选择私聊的窗口的
                PrivateUserProcedureJFrame pUser= PrivateUserProcedureJFrame.privateUserJFame.get(name);
                if(pUser == null){
                	pUser = new PrivateUserProcedureJFrame(name,this.name,client);
                	PrivateUserProcedureJFrame.privateUserJFame.put(name, pUser);
                    pUser.setVisible(true);
                }
                pUser.setVisible(true);
            }
            
            
        }
    }

    

    private  JScrollPane jScrollPane1;
    private  JButton logo;
    private  JList<Object> userJList;
    private  JLabel userNamelogo;
}

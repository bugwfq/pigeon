
package com.fuqiang.lan.view.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.fuqiang.lan.cm.client.Client;
import com.fuqiang.lan.view.ui.login.userlist.UserList;


/**
 *
 * @author Administrator
 */
public class ProcedureJFrame extends  JFrame {
	public static Map<String,ProcedureJFrame> userListJFame = new HashMap<>();
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UsersJFrameName;
	public Client client;
	public ProcedureJFrame(String name,String UsersJFrameName,Client client) {
		super(name);
		this.UsersJFrameName = UsersJFrameName;
		this.client = client;
        initComponents();
        init();
    }
    public final void init(){
        //设置屏幕居中
        JComponentTools.setFrameCenter(this);
        setTexeArealAttribute();//设置TexeArea其他属性
    }
    //设置文本框不可编辑  ,自动换行  不断字功能
    public void setTexeArealAttribute(){
        jTextArea1.setEditable(false);  //激活 不可编辑
        jTextArea1.setLineWrap(true);        //激活自动换行功能 
        jTextArea1.setWrapStyleWord(true);    // 激活断行不断字功能
    }
    
   //基本属性设置
    private void initComponents() {

        jScrollPane1 = new  JScrollPane();
        jTextArea1 = new  JTextArea();
        jButton1 = new  JButton();
        jButton2 = new  JButton();
        jScrollPane3 = new  JScrollPane();
        usersjList = new  JList<>();
        jScrollPane4 = new  JScrollPane();
        jEditorPane1 = new  JEditorPane();
        jComboBox1 = new  JComboBox<>();
        jButton3 = new  JButton();

        setDefaultCloseOperation( WindowConstants.HIDE_ON_CLOSE);
        setFocusCycleRoot(false);
        setName("窗口"); // NOI18N
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("发送");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("重置");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
		setUserList();
        usersjList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                usersjListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(usersjList);

        jScrollPane4.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jEditorPane1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                jEditorPane1KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jEditorPane1);

        jComboBox1.setModel(new  DefaultComboBoxModel<>(new String[] { "shift+enter", "enter" }));
        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton3.setText("上传文件");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(81, 81, 81)
                        .addComponent(jButton1,  GroupLayout.PREFERRED_SIZE, 69,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2,  GroupLayout.PREFERRED_SIZE, 74,  GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4,  GroupLayout.PREFERRED_SIZE, 315,  GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 315,  GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3,  GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 295,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane4,  GroupLayout.PREFERRED_SIZE, 117,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3,  GroupLayout.PREFERRED_SIZE, 468,  GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }
    //加载用户列表
    public void setUserList(){
        usersjList.setModel(new  AbstractListModel<Object>() {
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
    //用户列表的信息
    public Object[] userJlistAddUsers(){
    	Object[] users = UserList.getUser();
    	return users;
    }
    //提交按钮的操作
    private void jButton1ActionPerformed(ActionEvent evt) {
    	//将消息写出
    	writerMessage();
    }

   //重置按钮修改
    private void jButton2ActionPerformed(ActionEvent evt) {
       //文本框重置
       JComponentTools.setJTextFieldReset(jEditorPane1);
    }
    //判断下拉框的选择
    private void jComboBox1ItemStateChanged(ItemEvent evt) {
        if(evt.getStateChange() == ItemEvent.SELECTED){
            keyPreassedValue = getKeyPreassed(evt.getItem());
            keyPressed = 0;
        }
    }
    //返回点击键盘的值
    private int getKeyPreassed(Object obj ){

        if(obj.toString().equals("shift+enter")){
            return (KeyEvent.VK_SHIFT +KeyEvent.VK_ENTER);
        }else{
            return KeyEvent.VK_ENTER;
        }
    }
    
    private static int keyPreassedValue = (KeyEvent.VK_SHIFT +KeyEvent.VK_ENTER) ;//查看返回的键值
    private static int keyPressed ;//按键的值
    private static int count;//记录shift 和enter 错误次数
    public void jEditorPane1KeyReleased(KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_SHIFT ){
        	//判断发送方式
            keyPressed += evt.getKeyCode();
            //判断按键的值是否是选择的值
            if( keyPressed == keyPreassedValue){
            	//获取发送的内容

            	writerMessage();
                //将记录的值清空
                keyPressed = 0;
                count = 0;
            }else{
                //判断记录正确按键的次数
                if(count >= 1|| keyPressed>keyPreassedValue){//如果错误两次清空记录的数
                    count = 0;
                    keyPressed = 0;
                }
                 count++;//错误输入一次count加一次
            }
        }
    }
    //写出消息并发送到文本域
	private void writerMessage() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String date = form.format(new Date());
		String message = jEditorPane1.getText();
		//将消息写出
		client.send.send("@all:"+message.trim());
		//将消息发送到文本域
		jTextArea1.append(UsersJFrameName+"     "+date+"\r\n"+message.trim()+"\r\n");
		//获取光标清空内容
		JComponentTools.setJTextFieldReset(jEditorPane1);
	}
    //上传按钮
    private void jButton3ActionPerformed(ActionEvent evt) {
       //上传文件的文件窗口
        JFileChooser jFileChooser1  = new JFileChooser();
        if(jFileChooser1.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ){
      //弹出个对话框,选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
        System.out.println(jFileChooser1.getSelectedFile().getAbsolutePath());
        	client.send.sendFile("@filesStart#",jFileChooser1.getSelectedFile().getAbsolutePath());
        }
    }
    //群聊的用户列表
    private void usersjListMouseClicked(MouseEvent evt) {//GEN-FIRST:event_usersjListMouseClicked
         if(evt.getClickCount() == 2){
            JList<?> myList = (JList<?>) evt.getSource();
            int index = myList.getSelectedIndex();    //已选项的下标
            Object obj = myList.getModel().getElementAt(index);  //取出数据
            //获取点击的用户名
            String name = obj.toString();
            //在此处创建出选择私聊的窗口的
          //在此处创建出选择私聊的窗口的
            PrivateUserProcedureJFrame pUser= PrivateUserProcedureJFrame.privateUserJFame.get(name);
            if(pUser == null){
            	pUser = new PrivateUserProcedureJFrame(name,UsersJFrameName,client);
            	PrivateUserProcedureJFrame.privateUserJFame.put(name, pUser);
                pUser.setVisible(true);
            }
            pUser.setVisible(true);
        }
    }
    public JTextArea getJTextArea(){
    	return jTextArea1;
    }
    private  JButton jButton1;
    private  JButton jButton2;
    private  JButton jButton3;
    private  JComboBox<String> jComboBox1;
    private  JEditorPane jEditorPane1;
    private  JScrollPane jScrollPane1;
    private  JScrollPane jScrollPane3;
    private  JScrollPane jScrollPane4;
    private  JTextArea jTextArea1;
    private  JList<Object> usersjList;

}


package com.fuqiang.lan.view.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;

import com.fuqiang.lan.cm.client.Client;
import com.fuqiang.lan.cm.send.Send;

/**
 *
 * @author Administrator
 */
public class PrivateUserProcedureJFrame extends  JFrame {
	public static Map<String,PrivateUserProcedureJFrame> privateUserJFame = new HashMap<>();
    private String name;
    private String UsersJFrameName;
	private static final long serialVersionUID = 1L;
	private Client client;
    public PrivateUserProcedureJFrame(String name,String UsersJFrameName, Client client) {
    	
        super(name);
        this.name = name;
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
        jScrollPane4 = new  JScrollPane();
        jEditorPane1 = new  JEditorPane();
        jComboBox1 = new  JComboBox<>();
        jButton3 = new  JButton();

        setFocusCycleRoot(false);
        setName(""); // NOI18N
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4,  GroupLayout.PREFERRED_SIZE, 369,  GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1,  GroupLayout.PREFERRED_SIZE, 69,  GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2,  GroupLayout.PREFERRED_SIZE, 74,  GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 369,  GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 295,  GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jComboBox1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4,  GroupLayout.PREFERRED_SIZE, 117,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jButton2,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }
    //提交按钮的操作
    private void jButton1ActionPerformed(ActionEvent evt) {
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
    //键盘事件
    public void jEditorPane1KeyReleased(KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_SHIFT ){
           //判断发送方式
           keyPressed += evt.getKeyCode();
           //判断按键的值是否是选择的值
           if( keyPressed == keyPreassedValue){
           //写出消息
           writerMessage();
	       //将记录的值清空
	       keyPressed = 0;
	       count = 0;
	       }else{
           //判断记录正确按键的次数
	            if(count >= 1 || keyPressed>keyPreassedValue){//如果错误两次清空记录的数
	                 count = 0;
	                 keyPressed = 0;
	                 return;
               }
                count++;//错误输入一次count加一次
            }
        }
    }

    //将消息写出
	private void writerMessage() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String date = form.format(new Date());
		String message = jEditorPane1.getText();
		client.send.send("@:"+name+"##"+message);
	     //将消息发送到文本域
	    jTextArea1.append(UsersJFrameName+"	"+date+"\r\n"+message.trim()+"\r\n");
	    //获取光标清空内容
	    JComponentTools.setJTextFieldReset(jEditorPane1);
	}
    //上传按钮
    private void jButton3ActionPerformed(ActionEvent evt) {
       //上传文件的文件窗口
        JFileChooser jFileChooser1  = new JFileChooser();
        if(jFileChooser1.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ){
      //弹出个对话框,选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
        client.send.sendFile("@filesTo&"+name+"&#",jFileChooser1.getSelectedFile().getAbsolutePath());
     
        }
    }
    public JTextArea getJTextArea1(){
    	return jTextArea1;
    }
    private  JButton jButton1;
    private  JButton jButton2;
    private  JButton jButton3;
    private  JComboBox<String> jComboBox1;
    private  JEditorPane jEditorPane1;
    private  JScrollPane jScrollPane1;
    private  JScrollPane jScrollPane4;
    private  JTextArea jTextArea1;
}

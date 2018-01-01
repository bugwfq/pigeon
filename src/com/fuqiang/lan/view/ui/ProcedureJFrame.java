
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
        //������Ļ����
        JComponentTools.setFrameCenter(this);
        setTexeArealAttribute();//����TexeArea��������
    }
    //�����ı��򲻿ɱ༭  ,�Զ�����  �����ֹ���
    public void setTexeArealAttribute(){
        jTextArea1.setEditable(false);  //���� ���ɱ༭
        jTextArea1.setLineWrap(true);        //�����Զ����й��� 
        jTextArea1.setWrapStyleWord(true);    // ������в����ֹ���
    }
    
   //������������
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
        setName("����"); // NOI18N
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("����");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("����");
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

        jButton3.setText("�ϴ��ļ�");
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
    //�����û��б�
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
    //�û��б����Ϣ
    public Object[] userJlistAddUsers(){
    	Object[] users = UserList.getUser();
    	return users;
    }
    //�ύ��ť�Ĳ���
    private void jButton1ActionPerformed(ActionEvent evt) {
    	//����Ϣд��
    	writerMessage();
    }

   //���ð�ť�޸�
    private void jButton2ActionPerformed(ActionEvent evt) {
       //�ı�������
       JComponentTools.setJTextFieldReset(jEditorPane1);
    }
    //�ж��������ѡ��
    private void jComboBox1ItemStateChanged(ItemEvent evt) {
        if(evt.getStateChange() == ItemEvent.SELECTED){
            keyPreassedValue = getKeyPreassed(evt.getItem());
            keyPressed = 0;
        }
    }
    //���ص�����̵�ֵ
    private int getKeyPreassed(Object obj ){

        if(obj.toString().equals("shift+enter")){
            return (KeyEvent.VK_SHIFT +KeyEvent.VK_ENTER);
        }else{
            return KeyEvent.VK_ENTER;
        }
    }
    
    private static int keyPreassedValue = (KeyEvent.VK_SHIFT +KeyEvent.VK_ENTER) ;//�鿴���صļ�ֵ
    private static int keyPressed ;//������ֵ
    private static int count;//��¼shift ��enter �������
    public void jEditorPane1KeyReleased(KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_SHIFT ){
        	//�жϷ��ͷ�ʽ
            keyPressed += evt.getKeyCode();
            //�жϰ�����ֵ�Ƿ���ѡ���ֵ
            if( keyPressed == keyPreassedValue){
            	//��ȡ���͵�����

            	writerMessage();
                //����¼��ֵ���
                keyPressed = 0;
                count = 0;
            }else{
                //�жϼ�¼��ȷ�����Ĵ���
                if(count >= 1|| keyPressed>keyPreassedValue){//�������������ռ�¼����
                    count = 0;
                    keyPressed = 0;
                }
                 count++;//��������һ��count��һ��
            }
        }
    }
    //д����Ϣ�����͵��ı���
	private void writerMessage() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String date = form.format(new Date());
		String message = jEditorPane1.getText();
		//����Ϣд��
		client.send.send("@all:"+message.trim());
		//����Ϣ���͵��ı���
		jTextArea1.append(UsersJFrameName+"     "+date+"\r\n"+message.trim()+"\r\n");
		//��ȡ����������
		JComponentTools.setJTextFieldReset(jEditorPane1);
	}
    //�ϴ���ť
    private void jButton3ActionPerformed(ActionEvent evt) {
       //�ϴ��ļ����ļ�����
        JFileChooser jFileChooser1  = new JFileChooser();
        if(jFileChooser1.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ){
      //�������Ի���,ѡ��Ҫ�ϴ����ļ�,���ѡ����,�Ͱ�ѡ����ļ��ľ���·����ӡ����,���˾���·��,ͨ��JTextField��settext�������ý�ȥ��,�Ǹ���ûд
        System.out.println(jFileChooser1.getSelectedFile().getAbsolutePath());
        	client.send.sendFile("@filesStart#",jFileChooser1.getSelectedFile().getAbsolutePath());
        }
    }
    //Ⱥ�ĵ��û��б�
    private void usersjListMouseClicked(MouseEvent evt) {//GEN-FIRST:event_usersjListMouseClicked
         if(evt.getClickCount() == 2){
            JList<?> myList = (JList<?>) evt.getSource();
            int index = myList.getSelectedIndex();    //��ѡ����±�
            Object obj = myList.getModel().getElementAt(index);  //ȡ������
            //��ȡ������û���
            String name = obj.toString();
            //�ڴ˴�������ѡ��˽�ĵĴ��ڵ�
          //�ڴ˴�������ѡ��˽�ĵĴ��ڵ�
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

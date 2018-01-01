package com.fuqiang.servers.ud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fuqiang.servers.entity.User;
import com.fuqiang.servers.um.UserManager;

public class DomUserList {
	
	
		
		
	
	
	/**
	 * 加载到map集合中
	 */
	public static void load() {
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = null;
		//获取dom树
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File("src/com/fuqiang/servers/ud/userList.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		typeInMap(document);
	}
	public static void typeInMap(Document document){
		//获取根节点
		Element rootElement = document.getDocumentElement();
		NodeList userNodes = rootElement.getElementsByTagName("user");
		for(int i = 0 ; i < userNodes.getLength();i ++){
			//user节点
			Element user = (Element)userNodes.item(i);
			addUsers(user);
		}
	}
	public static void addUsers(Element user){
		//获取所有user子类
		NodeList userChilds = user.getChildNodes();
	
		//user子类
		Node userNameNode = userChilds.item(1);
		//判断节点是否是id	
		Node userPasswordNode = userChilds.item(3);
		//判断节点是否是id	
		User newUser = new User(userNameNode.getTextContent(),userPasswordNode.getTextContent());
		UserManager.addUser(newUser);
	}
	//
	public static void refresh() throws TransformerFactoryConfigurationError {
		
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		Document document = builder.newDocument();
		Element rootElem = document.createElement("userList");
		userMapToDocument(document,rootElem);
		//创建写入文件工厂
		writerXML(document);
	}
	//将map中的信息存入document中
	public static void userMapToDocument(Document document,Element rootElem){
		Set<String> keys = UserDao.map.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String userName = iter.next();
			User user = UserDao.map.get(userName);
			Element userEle = getNewUser(document,user.getUserName(),user.getUserPassword());
			rootElem.appendChild(userEle);
		}
		document.appendChild(rootElem);
	}
	public static Element getNewUser(Document document,String name,String password){
		Element user = document.createElement("user");
		Element userName = document.createElement("username");
		userName.setTextContent(name);
		Element userPassword = document.createElement("password");
		userPassword.setTextContent(password);
		user.appendChild(userName);
		user.appendChild(userPassword);
		return user;
	}
	
	//将document写入xml文档
	private static void writerXML(Document document) throws TransformerFactoryConfigurationError {
		TransformerFactory xmlfactory = TransformerFactory.newInstance(); 
		//文件写入器
		Transformer transformer;
		try {
			transformer = xmlfactory.newTransformer();
			//获取dom树
			DOMSource source = new DOMSource(document);  
			//创建写入流
	        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/com/fuqiang/servers/ud/userList.xml"))); 
	        //传入写入的结果
	        StreamResult result = new StreamResult(pw);  
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(source, result);  
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}

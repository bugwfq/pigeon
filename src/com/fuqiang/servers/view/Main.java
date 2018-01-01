package com.fuqiang.servers.view;

import com.fuqiang.servers.view.ui.SocketJFrame;

public class Main {
	public static void main(String[] args) {
		SocketJFrame run = new SocketJFrame();
		SocketJFrame.socketlist.add(run);
		run.setVisible(true);
	}
}

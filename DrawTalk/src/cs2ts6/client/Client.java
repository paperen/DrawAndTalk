package cs2ts6.client;

import java.util.ArrayList;

import javax.swing.JFrame;

import cs2ts6.packets.*;
/**
 * 
 * @author stephen
 *
 */
public class Client {
	private ArrayList<Packet> packets;
	private DrawingCanvas canvas;
	private ChatPanel chat;
	private boolean onServer = false, host = false;
	private JFrame master;
	/**
	 * Construct the client class with refernces to canvas and chat windows
	 * @param cnv Canvas reference
	 * @param cht Chat window reference
	 */
	public Client(DrawingCanvas cnv, ChatPanel cht, JFrame frame) {
		master = frame;
		canvas = cnv;
		chat = cht;
		packets = new ArrayList<Packet>();
		// Start UDP Listening Thread
		new Client2Thread(canvas, chat, this).start();
	}
	/**
	 * Send point to server, will auto return message back in mock client
	 * @param pnt
	 */
	public void sendPoints(PointPacket pnt) {
		packets.add(pnt);
	}
	/**
	 * Send message t server, will auto return to chat window for mock client
	 * @param cht
	 */
	public void sendMessage(ChatPacket cht) {
		packets.add(cht);
	}
	/**
	 * 
	 * @param t True-Connected False-noConnection
	 */
	public void onServerSet(boolean t) {
		onServer = t;
		packets.clear(); // Removes old packets in the buffer
		if(onServer) {
			master.setTitle("Draw & Talk - Team 11 - **ONLINE**");
			if(host) {
				master.setTitle("Draw & Talk - Team 11 - **ONLINE - HOSTING EMBEDDED SERVER**");
			}
		} else {
			master.setTitle("Draw & Talk - Team 11 - **OFFLINE**");
		}
	}
	/**
	 * Checks status of server connection
	 * @return True - connected, False - None
	 */
	public boolean onServerGet() {
		return onServer;
	}
	
	public void setHostTitle() {
		host = true;
	}
	
	/**
	 * Used by CleintSendThread for communicating a packet from Client->Server
	 * @return The packet to be transmitted
	 */
	public Packet getPacketToSend() {
		//System.out.println(packets.size());
		while (packets.size() == 0) {
			try {
				Thread.sleep(10);
				return new ChatPacket("KEEPALIVE","");
			} catch (InterruptedException e) {}
		}
		//Then return packet when one exists
		Packet pkt = packets.get(0);
		packets.remove(0);
		return pkt;
	}
	
	
	
	/**
	 * Testing main
	 */
	/*public static void main(String[] args) {
		new Client2Thread(null, null, ).start();
		//new ClientSendThread().start();
	}*/
}

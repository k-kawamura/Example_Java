import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException {
		
		//SocketServerインスタンス生成
		SocketServer socket_server  = new SocketServer();
		
		//socket_serverの実行
		socket_server.run();
		
		
		
	}
}

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	static final int PORT = 10000;
	
	public void run() {
		ServerSocket serverSocket = null;
		 
        try {
            serverSocket = new ServerSocket(PORT);
 
            boolean runFlag = true;
 
            while(runFlag){
 
                System.out.println("start wait...");
 
                // 接続があるまでブロック
                Socket socket = serverSocket.accept();
 
                BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
 
                String str;
                while( (str = br.readLine()) != null ){
                    System.out.println(str);
 
                    // exitという文字列を受け取ったら終了する
                    if( "exit".equals(str)){
                        runFlag = false;
                    }
                }
 
                if( socket != null){
                    socket.close();
                    socket = null;
                }
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
 
        if( serverSocket != null){
            try {
                serverSocket.close();
                serverSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}

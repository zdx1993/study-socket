import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Clinet {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        //设置超时时间
        socket.setSoTimeout(3000);
        //连接超时时间
        //因为我们是与本机的不同进程进行信息交流所以Inet4Address.getLocalHost()
        //客户端与本机的2000端口进行信息交流
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000),3000);
        System.out.println("已发起服务器连接请求,并进入后续流程");

        System.out.println("客户端信息:" + socket.getLocalAddress() + "p:" +socket.getLocalPort());

        //inet 应该是 internet 的意思
        System.out.println("服务端信息:" + socket.getInetAddress()+ "p:" +socket.getPort());

        try {
            //发送消息
            todo(socket);
        } catch (Exception e) {
            System.out.println("发生异常关闭,尝试关闭socket连接");
            //释放资源
            socket.close();
            System.out.println("客户端正常关闭...");
        }

    }

    private static void todo(Socket client) throws IOException {
        String sendMessage = "今天天气不错啊";

        //得到socket输出流,并转换为打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        //得到socket输入流,并转换为BufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //将信息发送到服务器
        printStream.print(sendMessage);

        //从服务器读取一行数据
        String s = bufferedReader.readLine();
        i
    }
}

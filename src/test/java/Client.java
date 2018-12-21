import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Descript DOTO
 * @Author fuyuanming
 * @Date 2018-07-16 17:45:27
 * @Version 1.0
 */
public class Client {

    public String host = "localhost";

    public int port = 9997;

    public Channel channel;

    public void connect() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ClientInitializer());
            ChannelFuture future = bootstrap.connect(host, port);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        Student student = new Student();
                        student.setName("xiaoming");
                        student.setAge(25);
                        channel.writeAndFlush(student);
                    } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Student student = new Student();
                                student.setName("xiaoming");
                                student.setAge(25);
                                channel.writeAndFlush(student);
                            }
                        });
                        thread.start();
                        System.out.println("failure");
                    }
                }
            });
            channel = future.channel();
            channel.close().sync();

        } catch (Exception e) {
            workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.connect();

    }

}

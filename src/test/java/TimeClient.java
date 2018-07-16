import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetSocketAddress;

/**
 * @Descript DOTO
 * @Author fuyuanming
 * @Date 2018-07-16 17:45:27
 * @Version 1.0
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {

        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                public void initChannel(SocketChannel socketChannel) {
                    socketChannel.pipeline().addLast(new ClientHandler());
                }
            });
            Channel channel = bootstrap.connect("localhost", 9999).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                String line = in.readLine();
                if (line == null) {
                    continue;
                }
                channel.writeAndFlush(line + "\r\n");
            }
        } catch (InterruptedException e) {
            workGroup.shutdownGracefully();
        }

    }

}

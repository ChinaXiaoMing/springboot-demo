package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description Netty客户端实现
 * @Author xiaoming
 * @Date 2020-03-19 21:24:36
 * @Version 1.0
 **/
public class Client {

    private Logger logger = LoggerFactory.getLogger(Client.class);
    //连接目标服务器地址，默认地址：localhost
    public String host = "localhost";
    //连接目标服务器端口，默认端口：9997
    public int port = 9997;

    public Channel channel;

    public Client() {}

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 连接服务器
     */
    public void connect() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            //添加业务处理handler
            bootstrap.handler(new ClientInitializer());
            //绑定服务器连接
            ChannelFuture future = bootstrap.connect(host, port);
            //监听客户端连接事件
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    logger.info("成功连接到【{}:{}】服务器", host, port);
                }
            });
            channel = future.channel();
            channel.close().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws IOException {
        //连接服务器
        new Client().connect();
    }

}

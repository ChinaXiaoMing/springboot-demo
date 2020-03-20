package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Descript Netty服务器
 * @Author fuyuanming
 * @Date 2018-07-16 16:52:14
 * @Version 1.0
 */
public class Server {

    private static Logger logger = LoggerFactory.getLogger(Server.class);
    //服务器绑定端口
    public int port;

    /**
     * 服务器启动流程
     * @param port 服务器绑定端口
     */
    public void startServer(int port) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = serverBootstrap.bind(port).sync();
            //监听服务器启动
            future.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    logger.info("Server startup successful, listen on {}", port);
                }
            });
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error("Netty server start error, reason: {}", e.toString());
        } finally {
            //释放资源
            workGroup.shutdownGracefully();
            eventLoopGroup.shutdownGracefully();
        }
    }

    /**
     * 服务器启动入口main方法
     * @param args
     */
    public static void main(String[] args) {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 9997;
        }
        new Server().startServer(port);
    }

}

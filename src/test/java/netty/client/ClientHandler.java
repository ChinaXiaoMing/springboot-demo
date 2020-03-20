package netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/03/19 21:08:54
 * @Version 1.0
 **/
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    private Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    /**
     * 获取服务端数据
     * @param channelHandlerContext ChannelHandler上下文
     * @param msg 读取的消息
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        logger.debug("成功接收到服务器消息：{}", msg);
    }

    /**
     * 连接成功激活方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端成功连接服务器！");
    }

    /**
     * 客户端闲置时调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端连接闲置！");
        ctx.channel().close();
    }



}

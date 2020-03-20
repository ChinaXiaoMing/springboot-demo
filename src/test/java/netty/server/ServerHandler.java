package netty.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * @Description 自定义业务处理器
 * @Author xiaoming
 * @Date 2020-03-19 21:38:56
 * @Version 1.0
 **/
public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    /**
     * 读取客户端消息，并给客户端响应消息
     * @param ctx ChannelHandler上下文
     * @param fullHttpRequest
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest fullHttpRequest) throws Exception {
        System.out.println("class:" + fullHttpRequest.getClass().getName());
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer("test".getBytes()));

        HttpHeaders heads = response.headers();
        heads.add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN + "; charset=UTF-8");
        heads.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        heads.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        ctx.write(response);
    }

    /**
     * 消息读取完成时
     * @param ctx ChannelHandler上下文
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("Channel read complete!");
        super.channelReadComplete(ctx);
        ctx.flush();
    }

    /**
     * 客户端连接时调用
     * @param ctx ChannelHandler上下文
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Remote address: {} is active!", ctx.channel().remoteAddress());
        ctx.writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
    }

    /**
     * io异常处理
     * @param ctx ChannelHandler上下文
     * @param cause 错误异常类
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("连接异常，断开连接：{}", cause.toString());
    }

    /**
     * 服务器闲置时调用
     * @param ctx ChannelHandler上下文
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        //关闭闲置的channel
        ctx.channel().close();
    }
}

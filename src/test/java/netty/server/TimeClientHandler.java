package netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @Descript 官网TimeChannelHandler案例
 * @Author fuyuanming
 * @Date 2018-07-16 17:50:49
 * @Version 1.0
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf message = (ByteBuf) msg;
        try {
            System.out.println("message:" + message);
            Long currentTimeMillis = (message.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println("时间是：" + new Date(currentTimeMillis));
            ctx.close();
        } catch (Exception e) {
            message.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

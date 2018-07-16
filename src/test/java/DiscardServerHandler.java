import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @Descript DOTO
 * @Author fuyuanming
 * @Date 2018-07-16 17:25:37
 * @Version 1.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                //white response message
                byte[] bytes = "hello world".getBytes();
                in.writeBytes(bytes);
                context.write(msg);
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable throwable) {
        throwable.printStackTrace();
        context.close();
    }

}

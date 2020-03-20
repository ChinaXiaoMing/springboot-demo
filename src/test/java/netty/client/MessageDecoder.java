package netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * @Description 自定义解码器
 * @Author xiaoming
 * @Date 2020/03/19 21:09:47
 * @Version 1.0
 **/
public class MessageDecoder extends ByteToMessageDecoder {
    /**
     * 消息解码 字节 ===> POJO
     * @param channelHandlerContext channelHandler上下文
     * @param byteBuf 字节缓存区
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 0) {
            return;
        }
        ByteBuf buf = Unpooled.buffer(5);
        try {
            // TODO 字节码解码成POJO对象
        } finally {
            if(buf != null){
                ReferenceCountUtil.release(buf);
            }
        }
    }
}

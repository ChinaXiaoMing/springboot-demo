import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 0) {
            return;
        }
        ByteBuf buf = Unpooled.buffer(5);
        try {
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            String msg = new String(bytes, CharsetUtil.UTF_8);
            Student student = new Student();
            student.setName(msg);
            //list.add(student);
        } finally {
            if(buf != null){
                ReferenceCountUtil.release(buf);
            }
        }
    }
}

package netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020-03-19 21:26:31
 * @Version 1.0
 **/
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //解码器
        socketChannel.pipeline().addLast("decoder", new MessageDecoder());
        //编码器
        socketChannel.pipeline().addLast("encoder", new StringEncoder());
        //自定义处理器
        socketChannel.pipeline().addLast("handler", new ClientHandler());
    }
}

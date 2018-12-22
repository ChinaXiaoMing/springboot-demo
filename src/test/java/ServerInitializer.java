import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //解码器
        socketChannel.pipeline().addLast("decoder", new HttpRequestDecoder());
        //编码器
        socketChannel.pipeline().addLast("encoder", new HttpResponseEncoder());
        socketChannel.pipeline().addLast("aggregator", new HttpObjectAggregator(512 * 1024));
        //自定义处理器
        socketChannel.pipeline().addLast("handler", new ServerHandler());
    }
}

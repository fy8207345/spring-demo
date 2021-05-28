package org.example.nio;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class NioTest {

    @Rule
    public WireMockRule rule = new WireMockRule(9999);

    @Before
    public void setup(){
        stubFor(get(urlEqualTo("/test"))
                .willReturn(aResponse().withStatus(200).withBody("response body!")));
    }

    @Test
    public void test() throws IOException {
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        SocketChannel socketChannel = SocketChannel.open(address);
        Charset charset = StandardCharsets.UTF_8;
        socketChannel.write(charset.encode(CharBuffer.wrap("GET /test HTTP/1.0\r\n\r\n")));
        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer charBuffer = CharBuffer.allocate(8192);
        StringBuilder stringBuilder = new StringBuilder();
        while (socketChannel.read(byteBuffer) != -1 || byteBuffer.position() > 0){
            byteBuffer.flip();
            storeBufferContents(byteBuffer, charBuffer, charsetDecoder, stringBuilder);
            byteBuffer.compact();
        }
        System.out.println("received: " + stringBuilder);
        socketChannel.close();
    }

    void storeBufferContents(ByteBuffer byteBuffer, CharBuffer charBuffer,
                             CharsetDecoder charsetDecoder, StringBuilder ourStore) {
        charsetDecoder.decode(byteBuffer, charBuffer, true);
        charBuffer.flip();
        ourStore.append(charBuffer);
        charBuffer.clear();
    }
}

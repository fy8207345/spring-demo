package org.example.io;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class IoTest {
    @Rule
    public WireMockRule rule = new WireMockRule(9999);

    @Before
    public void setup(){
        stubFor(get(urlEqualTo("/test"))
        .willReturn(aResponse().withStatus(200).withBody("response body!")));
    }

    @Test
    public void read() throws IOException {
        Socket socket = new Socket("localhost", 9999);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        printWriter.print("GET " + "/test" + " HTTP/1.0\r\n\r\n");
        printWriter.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        for(String line;(line = bufferedReader.readLine()) != null;){
            builder.append(line);
            builder.append(System.lineSeparator());
        }
        System.out.println("recevied : " + builder.toString());
        socket.close();
    }
}

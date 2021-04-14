package com.luobo.utils;


import com.luobo.query.wx.TestQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class HttpXmlUtil {

    private String method = "POST";
    private String charset = "UTF-8";
    private String contentType = "text/xml";

    public String sendXmlMsg(String address, String xmlMsg) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestProperty("Content-Type", contentType);
        conn.connect();
        // 向输出流写出数据
        PrintWriter pw = new PrintWriter(conn.getOutputStream());
        pw.write(xmlMsg);
        pw.flush();
        pw.close();
        String contentType = conn.getContentType();
        Pattern pattern = Pattern.compile("charset=.*:?");
        Matcher matcher = pattern.matcher(contentType);
        if (matcher.find()) {
            charset = matcher.group();
            if (charset.endsWith(";")) {
                charset = charset.substring(charset.indexOf("=") + 1, charset.indexOf(";"));
            } else {
                charset = charset.substring(charset.indexOf("=") + 1);
            }
            if (charset.contains("\"")) {
                charset = charset.substring(1, charset.length() - 1);
            }
            charset = charset.trim();
        }

        InputStream inStream = conn.getInputStream();
        BufferedReader ufferedReader = new BufferedReader(new InputStreamReader(inStream, charset));
        String line;
        while ((line = ufferedReader.readLine()) != null) {
            sb.append(line);
        }
        ufferedReader.close();
        conn.disconnect();
        return sb.toString();
    }


    public void toxml(TestQuery query) throws Exception {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Service>\n" +
                "\t<app_HEAD>\n" +
                "\t\t<authrCardFlag>string</authrCardFlag>\n" +
                "\t\t<authrCardNo>string</authrCardNo>\n" +
                "\t\t<authrPwd>string</authrPwd>\n" +
                "\t\t<authrTellerNo>string</authrTellerNo>\n" +
                "\t\t<branchId>string</branchId>\n" +
                "\t\t<cityCode>string</cityCode>\n" +
                "\t\t<globalSepNo>string</globalSepNo>\n" +
                "\t\t<langCode>string</langCode>\n" +
                "\t\t<terminalCode>string</terminalCode>\n" +
                "\t\t<tranDate>string</tranDate>\n" +
                "\t\t<tranSepNo>string</tranSepNo>\n" +
                "\t\t<tranTellerNo>string</tranTellerNo>\n" +
                "\t\t<tranTime>string</tranTime>\n" +
                "\t</app_HEAD>\n" +
                "\t<BODY>\n" +
                "\t\t<AtchInstNo>" + query.getAtchInstNo() + "</AtchInstNo>\n" +
                "\t\t<BsnNo>" + query.getBsnNo() + "</BsnNo>\n" +
                "\t\t<EmpeNo>" + query.getEmpeNo() + "</EmpeNo>\n" +
                "\t\t<SrvIP>" + query.getSrvIP() + "</SrvIP>\n" +
                "\t\t<WndwNo>" + query.getWndwNo() + "</WndwNo>\n" +
                "\t</BODY>\n" +
                "\t<sys_HEAD>\n" +
                "\t\t<consumerId>string</consumerId>\n" +
                "\t\t<extendContent>string</extendContent>\n" +
                "\t\t<mac>string</mac>\n" +
                "\t\t<msgId>string</msgId>\n" +
                "\t\t<replyAdr>string</replyAdr>\n" +
                "\t\t<serviceCode>string</serviceCode>\n" +
                "\t\t<sourceSysId>string</sourceSysId>\n" +
                "\t</sys_HEAD>\n" +
                "</Service>";


        /**
         * 网点内部机构号
         */
        Integer bsnNo = Integer.parseInt(query.getBsnNo());
        int a = bsnNo.intValue();
        a++;
        String b = a + "";
        query.setBsnNo(b);
        HttpXmlUtil httpXmlUtil = new HttpXmlUtil();
        httpXmlUtil.sendXmlMsg(query.getUrl(), xmlString);
    }


}



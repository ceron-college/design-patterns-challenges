package com.ceron.decorators;

import com.ceron.messages.MessageInterface;

public class CompanyInfoDecorator extends MessageDecorator {

    private String companyName;
    private String address;
    private String phone;
    private String companyEmail;

    public CompanyInfoDecorator(MessageInterface formatMessage, String companyName, String address, String phone, String companyEmail) {
        super(formatMessage);
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.companyEmail = companyEmail;
    }

    @Override
    public MessageInterface ProcessMessage() {
        messageFormat = messageFormat.ProcessMessage();
        messageFormat = addCompanyInfo();
        return messageFormat;
    }

    private MessageInterface addCompanyInfo() {
        String content = messageFormat.getContent();
        String bodyCloseTag = "</soapenv:Body>";
        int bodyCloseIndex = content.indexOf(bodyCloseTag);
        if (bodyCloseIndex != -1) {
            String companyInfo = "<footer>\n" + "   <companyName>" + companyName + "</companyName>\n" + "   <address>" + address + "</address>\n" + "   <phone>" + phone + "</phone>\n" + "   <companyEmail>" + companyEmail + "</companyEmail>\n" + "</footer>\n";
            content = content.substring(0, bodyCloseIndex) + companyInfo + content.substring(bodyCloseIndex);
            messageFormat.setContent(content);
        } else {
            throw new RuntimeException("Closing </soapenv:Body> tag not found in SOAP message");
        }
        return messageFormat;
    }
}

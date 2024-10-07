package com.ceron.decorators;

import com.ceron.messages.MessageInterface;

public class SOAPCredentialsDecorator extends MessageDecorator {

    private String username;
    private String password;

    public SOAPCredentialsDecorator(MessageInterface formatMessage, String username, String password) {
        super(formatMessage);
        this.username = username;
        this.password = password;
    }

    @Override
    public MessageInterface ProcessMessage() {
        messageFormat = messageFormat.ProcessMessage();
        messageFormat = addCredentials();
        return messageFormat;
    }

    private MessageInterface addCredentials() {
        String content = messageFormat.getContent();
        String headerTag = "<soapenv:Header/>";
        int headerIndex = content.indexOf(headerTag);

        if (headerIndex != -1) {
            String credentials = "\n       <ser:credentials>\n" + "         <username>" + username + "</username>\n" + "         <password>" + password + "</password>\n" + "     </ser:credentials>\n";

            content = content.substring(0, headerIndex + headerTag.length() - 2) + ">" + credentials + "   </soapenv:Header>" + content.substring(headerIndex + headerTag.length());

            messageFormat.setContent(content);
        } else {
            throw new RuntimeException("Could not find <soapenv:Header> in SOAP message");
        }
        return messageFormat;
    }
}
package com.developerinc.mybatiscmsync.model;

public class EmailRequest {
    private String to;
    private String [] cc;
    private String subject;
    private String body;
    private String attachmentPath;




    public String [] getCc() {
        return cc;
    }
    public void setCc(String[] cc) {
        this.cc = cc;
    }


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
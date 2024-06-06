package com.melnikov.VkEchoBot.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VkObject {
    @JsonProperty("message")
    private VkMessageDetail messageDetail;

    public VkMessageDetail getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(VkMessageDetail messageDetail) {
        this.messageDetail = messageDetail;
    }

    @Override
    public String toString() {
        return "VkObject{" +
                "messageDetail=" + messageDetail +
                '}';
    }
}

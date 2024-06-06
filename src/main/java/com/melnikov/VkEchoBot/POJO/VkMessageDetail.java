package com.melnikov.VkEchoBot.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VkMessageDetail {
    private String text;

    @JsonProperty("from_id")
    private String fromId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    @Override
    public String toString() {
        return "VkMessageDetail{" +
                "text='" + text + '\'' +
                ", fromId='" + fromId + '\'' +
                '}';
    }
}
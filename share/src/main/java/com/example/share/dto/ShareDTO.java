package com.example.share.dto;

public class ShareDTO {

    private Long contentId;
    private Long userId;

    // Getters et Setters
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
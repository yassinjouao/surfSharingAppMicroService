package com.example.share.service;

import com.example.share.dto.ShareDTO;
import com.example.share.entity.Shares;

import java.util.List;

public interface ShareServiceI {
    Shares addShare(ShareDTO shareDTO);

    List<Shares> getSharesByUserId(Long userId);

    List<Shares> getSharesByContentId(Long contentId);

    List<Shares> getAllShares();

}
package com.example.share;

import java.util.List;

public interface ShareServiceI {
    Shares addShare(ShareDTO shareDTO);

    List<Shares> getSharesByUserId(Long userId);

    List<Shares> getSharesByContentId(Long contentId);

    List<Shares> getAllShares();

}
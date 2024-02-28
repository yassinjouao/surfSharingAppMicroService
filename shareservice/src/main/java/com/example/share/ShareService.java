package com.example.share;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ShareService implements ShareServiceI {

    private final ShareRepository shareRepository;
/*
    @Autowired
    public ShareService(ShareRepository shareRepository) {

        this.shareRepository = shareRepository;
    }
 */
    @Override
    public Shares addShare(ShareDTO shareDTO) {
        Shares share = new Shares();
        share.setContentId(shareDTO.getContentId());
        share.setUserId(shareDTO.getUserId());
        return shareRepository.save(share);
    }

    @Override
    public List<Shares> getSharesByUserId(Long userId) {
        return shareRepository.findByUserId(userId);
    }

    @Override
    public List<Shares> getSharesByContentId(Long contentId) {
        return shareRepository.findByContentId(contentId);
    }

    @Override
    public List<Shares> getAllShares() {
        return shareRepository.findAll();
    }

}



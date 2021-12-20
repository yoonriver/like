package com.project.like.service;

import com.project.like.Entity.LikeEntity;

import java.util.List;

public interface NoticeService {

    public void likesCount(Long noticeId, List<LikeEntity> list);
}

package com.project.like.service;

import com.project.like.Entity.LikeEntity;
import com.project.like.Entity.NoticeEntity;
import com.project.like.Repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoticeServiceImpl implements NoticeService{

    NoticeRepository noticeRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public void likesCount(Long noticeId, List<LikeEntity> list) {
        Optional<NoticeEntity> findNotice = noticeRepository.findById(noticeId);
        NoticeEntity notice = findNotice.get();
        notice.setLikes_count(list.size());
        noticeRepository.save(notice);

    }
}

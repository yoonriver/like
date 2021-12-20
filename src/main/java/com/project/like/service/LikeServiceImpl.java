package com.project.like.service;


import com.project.like.Entity.LikeEntity;
import com.project.like.Entity.MemberEntity;
import com.project.like.Entity.NoticeEntity;
import com.project.like.Repository.LikeRepository;
import com.project.like.Repository.MemberRepository;
import com.project.like.Repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@Component
public class LikeServiceImpl implements LikeService{

    LikeRepository likeRepository;
    MemberRepository memberRepository;
    NoticeRepository noticeRepository;
    NoticeServiceImpl noticeService;

    public LikeServiceImpl(LikeRepository likeRepository, MemberRepository memberRepository, NoticeRepository noticeRepository, NoticeServiceImpl noticeService) {
        this.likeRepository = likeRepository;
        this.memberRepository = memberRepository;
        this.noticeRepository = noticeRepository;
        this.noticeService = noticeService;
    }

    @Override
    public void likes(long memberId, long noticeID) {
        // like가 존재하지 않으면 like 추가
        if(!isAlreadyLike(memberId, noticeID)) {
            Optional<MemberEntity> findMemberId = memberRepository.findById(memberId);
            MemberEntity member = findMemberId.get();
            Optional<NoticeEntity> findNoticeId = noticeRepository.findById(noticeID);
            NoticeEntity notice = findNoticeId.get();

            LikeEntity like = new LikeEntity();
            like.setNotice(notice);
            like.setMember(member);

            likeRepository.save(like);
            // 총 좋아요 집계
            List<LikeEntity> LikeList = likeRepository.findByNotice_Id(noticeID);
            noticeService.likesCount(noticeID, LikeList);

        // like가 존재하면 삭제    
        }else {
            likeRepository.deleteByMember_Id(memberId);
            //총 좋아요 집계
            List<LikeEntity> LikeList = likeRepository.findByNotice_Id(noticeID);
            noticeService.likesCount(noticeID, LikeList);
        }
    }

    public boolean isAlreadyLike(long memberId, long noticeId) {
        boolean result = likeRepository.existsByMember_IdAndNotice_Id(memberId, noticeId);

        return result;
    }
}

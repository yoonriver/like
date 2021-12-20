package com.project.like;

import com.project.like.Entity.LikeEntity;
import com.project.like.Entity.MemberEntity;
import com.project.like.Entity.NoticeEntity;
import com.project.like.Repository.LikeRepository;
import com.project.like.Repository.MemberRepository;
import com.project.like.Repository.NoticeRepository;
import com.project.like.service.LikeService;
import com.project.like.service.LikeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class test {

    MemberRepository memberRepository;
    LikeRepository likeRepository;
    NoticeRepository noticeRepository;
    LikeService likeService;

    @Autowired
    public test(MemberRepository memberRepository, LikeRepository likeRepository, NoticeRepository noticeRepository, LikeService likeService) {
        this.memberRepository = memberRepository;
        this.likeRepository = likeRepository;
        this.noticeRepository = noticeRepository;
        this.likeService = likeService;
    }

    @Test
    void test1() {
        MemberEntity member1 = new MemberEntity();
        memberRepository.save(member1);

        MemberEntity member2 = new MemberEntity();
        memberRepository.save(member2);

        MemberEntity member3 = new MemberEntity();
        memberRepository.save(member3);

        NoticeEntity notice = new NoticeEntity();
        noticeRepository.save(notice);

        likeService.likes(member1.getId(), notice.getId());
        Boolean b1 = likeRepository.existsByMember_IdAndNotice_Id(member1.getId(), notice.getId());
        System.out.println("b1 = " + b1);

        likeService.likes(member2.getId(), notice.getId());
        Boolean b2 = likeRepository.existsByMember_IdAndNotice_Id(member2.getId(), notice.getId());
        System.out.println("b2 = " + b2);

        likeService.likes(member3.getId(), notice.getId());
        Boolean b3 = likeRepository.existsByMember_IdAndNotice_Id(member3.getId(), notice.getId());
        System.out.println("b3 = " + b3);

        Optional<NoticeEntity> findNotice = noticeRepository.findById(notice.getId());
        NoticeEntity noticeResult = findNotice.get();
        System.out.println("noticeResult.getLikes_count() = " + noticeResult.getLikes_count());

        likeService.likes(member1.getId(), notice.getId());
        b1 = likeRepository.existsByMember_IdAndNotice_Id(member1.getId(), notice.getId());
        System.out.println("b = " + b1);

        likeService.likes(member2.getId(), notice.getId());
        b2 = likeRepository.existsByMember_IdAndNotice_Id(member2.getId(), notice.getId());
        System.out.println("b = " + b2);

        likeService.likes(member3.getId(), notice.getId());
        b3 = likeRepository.existsByMember_IdAndNotice_Id(member3.getId(), notice.getId());
        System.out.println("b = " + b3);

        findNotice = noticeRepository.findById(notice.getId());
        noticeResult = findNotice.get();
        System.out.println("noticeResult.getLikes_count() = " + noticeResult.getLikes_count());


        //LikeEntity likeByMember_id = likeRepository.findLikeByMember_IdAndNotice_Id(member1.getId(), notice.getId());
        //System.out.println("likeByMember_id.getLike() = " + likeByMember_id.getLike_val());

    }

}

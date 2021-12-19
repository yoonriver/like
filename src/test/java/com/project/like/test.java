package com.project.like;

import com.project.like.Entity.LikeEntity;
import com.project.like.Entity.MemberEntity;
import com.project.like.Repository.LikeRepository;
import com.project.like.Repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LikeRepository likeRepository;

    @Test
    void test1() {
        MemberEntity member = new MemberEntity();
        memberRepository.save(member);

        LikeEntity likes = new LikeEntity();
        likes.setMember(member);
        likes.setLike_val(1);
        likeRepository.save(likes);

        LikeEntity likeByMember_id = likeRepository.findLikeByMember_Id(member.getId());
        System.out.println("likeByMember_id.getLike() = " + likeByMember_id.getLike_val());

        Assertions.assertThat(likes.getLike_val() == likeByMember_id.getLike_val());

    }

}

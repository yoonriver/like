package com.project.like.Repository;

import com.project.like.Entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {


    public LikeEntity findByMember_IdAndNotice_Id(Long memberId, Long noticeId);

    public List<LikeEntity> findByNotice_Id(Long noticeId);

    public boolean existsByMember_IdAndNotice_Id(Long memberId, Long noticeId);

   // @Modifying
    public void deleteByMember_Id(Long memberId);
}
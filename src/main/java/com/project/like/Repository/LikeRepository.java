package com.project.like.Repository;

import com.project.like.Entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {


    public LikeEntity findLikeByMember_Id(Long id);
}
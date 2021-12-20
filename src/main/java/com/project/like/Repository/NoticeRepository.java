package com.project.like.Repository;

import com.project.like.Entity.LikeEntity;
import com.project.like.Entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
}
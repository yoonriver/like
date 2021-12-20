package com.project.like.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NOTICE")
@Getter
@Setter
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICE_SEQ_GEN")
    private Long id;

    @OneToMany(mappedBy = "notice")
    List<LikeEntity> likeEntityList;

    private int likes_count;
}
package com.project.like.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@RequiredArgsConstructor
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String memberId;
}
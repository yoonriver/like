package com.project.like.Entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;



}
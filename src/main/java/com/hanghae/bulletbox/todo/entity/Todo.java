package com.hanghae.bulletbox.todo.entity;

import com.hanghae.bulletbox.common.entity.TimeStamped;
import com.hanghae.bulletbox.member.entity.Member;
import com.hanghae.bulletbox.todo.TodoBullet;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Todo extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(nullable = true)
    private Long categoryId;

    @Column(nullable = true)
    private String categoryColor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoBullet todoBullet;

    @Column(nullable = true)
    private String todoContent;

    @Column(nullable = true)
    private Long year;

    @Column(nullable = true)
    private Long month;

    @Column(nullable = true)
    private Long day;

    @Column(nullable = true)
    private String dayOfTheWeek;

    @Column(nullable = true)
    private String time;

    @Builder
    public Todo(Member member, Long categoryId, String categoryColor, TodoBullet todoBullet, String todoContent, Long year, Long month, Long day, String dayOfTheWeek, String time) {
        this.member = member;
        this.categoryId = categoryId;
        this.categoryColor = categoryColor;
        this.todoBullet = todoBullet;
        this.todoContent = todoContent;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfTheWeek = dayOfTheWeek;
        this.time = time;
    }
}

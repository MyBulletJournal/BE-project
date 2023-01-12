package com.hanghae.bulletbox.todo.repository;

import com.hanghae.bulletbox.member.entity.Member;
import com.hanghae.bulletbox.todo.entity.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByMember(Member member);

    List<Todo> findAllByMemberAndTodoYearAndTodoMonth(Member member, Long todoYear, Long todoMonth);

    List<Todo> findAllByMemberAndTodoYearAndTodoMonthAndTodoDay(Member member, Long todoYear, Long todoMonth, Long todoDay);
}
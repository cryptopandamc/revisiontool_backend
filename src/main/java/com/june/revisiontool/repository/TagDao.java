package com.june.revisiontool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.june.revisiontool.model.Tag;

public interface TagDao extends JpaRepository<Tag, Long> {

}

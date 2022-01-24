package com.june.revisiontool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.revisiontool.model.Tag;
import com.june.revisiontool.repository.TagDao;

@Service
public class TagService {

	
	@Autowired
	private TagDao tagDao;

	public void create(Tag tag) {
		tagDao.save(tag);
	}

	public Optional<Tag> retrieveOne(long tagId) {
		return tagDao.findById(tagId);
	}

	public List<Tag> retrieveAll() {
		return tagDao.findAll();
	}
	
	
}

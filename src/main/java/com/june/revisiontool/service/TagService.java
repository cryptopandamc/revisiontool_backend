package com.june.revisiontool.service;

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
	
	
}

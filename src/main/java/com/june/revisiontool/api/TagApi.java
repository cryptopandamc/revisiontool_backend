package com.june.revisiontool.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.june.revisiontool.model.Tag;
import com.june.revisiontool.service.TagService;

@RestController
@RequestMapping("/api/v1/tags/")
@CrossOrigin(origins = "http://localhost:3000")
public class TagApi {
	
	@Autowired
	private TagService tagService;

	@GetMapping("AllTags")
	public ResponseEntity<List<Tag>> allTags() {
		List<Tag> allTags = tagService.retrieveAll();
		return ResponseEntity.ok(allTags);
	}

}

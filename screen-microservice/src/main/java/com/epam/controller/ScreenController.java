package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Screen;
import com.epam.service.ScreenServices;

@RestController
@RequestMapping(value = "/screens")
public class ScreenController {
	@Autowired
	private ScreenServices screens;

	@PostMapping(value = "/screen")
	public Screen insert(@RequestBody Screen dto) {
		return screens.insert(dto);
	}

	@DeleteMapping(	value = "/{screenId}")
	public boolean delete(@PathVariable String screenId) {
		return screens.delete(screenId);
	}

	@GetMapping(value = "/All")
	public List<Screen> getAll() {
		return screens.getAllScreens();
	}

}

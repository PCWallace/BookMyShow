package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Shows;
import com.epam.service.ShowsServices;

@RestController
public class ShowsController {

	@Autowired
	private ShowsServices showsServices;

	@GetMapping(value = "/All")
	public List<Shows> getAllShows() {
		return showsServices.getAll();
	}

	@GetMapping(value = "{/showId}")
	public Shows getSowsByShowId(@PathVariable String showId) {
		return showsServices.getShowById(showId);
	}

	@PostMapping(value = "/show", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Shows> insertTheShow(@RequestBody List<Shows> showList) {
		return showsServices.insertAll(showList);
	}

	@DeleteMapping(value = "/{showId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Shows deletbyShowsId(@PathVariable String showId) {
		return showsServices.delete(showId);
	}
}

package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Dates;
import com.epam.service.DatesServices;

@RestController
public class DatesController {

	@Autowired
	private DatesServices dates;

	@GetMapping(value = "/All")
	public List<Dates> getAll() {
		return dates.getAll();
	}

	@GetMapping(value = "/{dateId}")
	public Dates getDateById(@PathVariable String dateId) {
		return dates.getDateByDateId(dateId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/date", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Dates inserDate(@RequestBody Dates dto) {
		return dates.insert(dto);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{dateId}")
	public Dates deleteDate(@PathVariable String dateId) {
		dates.delete(dateId);
		return getDateById(dateId);
	}
}

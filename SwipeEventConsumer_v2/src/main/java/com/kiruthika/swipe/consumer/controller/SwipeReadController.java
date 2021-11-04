package com.kiruthika.swipe.consumer.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthika.swipe.consumer.model.SwipeEvents;
import com.kiruthika.swipe.consumer.repo.SwipeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Employee", description = "REST API for Employee", tags = { "Employee" })
public class SwipeReadController {

	@Autowired
	private SwipeRepository swipeRepo;

	@ApiOperation(value = "Create Employee Swipe Event", notes = "Store Employees Swipe Events", nickname = "Store Swipe Events")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Returned if the property does not exist or the currently authenticated user does not have permission to view it."),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@PostMapping("/v1/api/employees")
	public SwipeEvents saveSwipeDetails(@RequestBody SwipeEvents employee) {
		List<SwipeEvents> empList = swipeRepo.findByEmpNo(employee.getEmpNo());
		List<SwipeEvents> matchList = empList.stream()
				.filter(emp -> (employee.getEmpNo() == emp.getEmpNo()) && (employee.getEventType().equals(emp.getEventType())))
				.collect(Collectors.toList());
		if(matchList!=null && matchList.size()==1)
		{
			System.out.println("inside if");
			SwipeEvents matched = matchList.get(0);
			matched.setSwipeTime(employee.getSwipeTime());
			return swipeRepo.save(matched);
		}
		return swipeRepo.save(employee);
		
	}

	@ApiOperation(value = "Get All Employee Swipe Events", notes = "Fetch All Employees Swipe Events", nickname = "Fetch All Employees")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@GetMapping("/v1/api/employees")
	public List<SwipeEvents> getAllSwipeDetails() {
		return swipeRepo.findAll();
	}

	@ApiOperation(value = "Get specific Employee", notes = "Fetch specific Employee Swipe Events", nickname = "Fetch Specific Employee")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Returned if an error occurs while retrieving the list of servers."),
			@ApiResponse(code = 404, message = "Returned if the employee does not exist or the currently authenticated user does not have permission to view it."),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 403, message = "Returned if the currently authenticated user does not have permission to view the employee details"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@GetMapping("/v1/api/employees/{empNo}")
	public List<SwipeEvents> getEmpSwipeDetails(@PathVariable String empNo) {
		return swipeRepo.findByEmpNo(Integer.parseInt(empNo));
	}
}

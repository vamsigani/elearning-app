package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PlanRestController {
	
	
	@Autowired
	private PlanService planservice;
	
	@GetMapping("/products")
	public ResponseEntity<Map<Integer,String>> planCatepores(){
		
		
		Map<Integer, String> getplaonCategors = planservice.getplanCategors();
		return new ResponseEntity<>(getplaonCategors, HttpStatus.OK);
		
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String>savePlan(@RequestBody Plan plan)
	{
		String Responsemsg="";  
		boolean saveplan = planservice.saveplan(plan);
		if(saveplan)
		{
			Responsemsg="Plan Saved";	
		}else
		{
			Responsemsg="Plan Faild";
		}
		return new ResponseEntity<>(Responsemsg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getallPlan()
	{
		List<Plan> plans = planservice.getPlans();
		return  new ResponseEntity<>(plans, HttpStatus.OK);
	}
	
	
	@PutMapping("/plan")
	public ResponseEntity<String> updateplan(@RequestBody Plan Plan)
	{
		boolean updatePlan = planservice.UpdatePlan(Plan);
		String msg="";
		if(updatePlan)
		{
			msg="Upadated SucessFully";
		}else
		{
			msg="Not Updated sucessFullu";
		}
		
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/plan/{planid}")
	public ResponseEntity<Plan>EditPlan(@PathVariable Integer PlanId)
	{
		Plan planById = planservice.getPlanById(PlanId);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}

	@DeleteMapping("/plan/{PlanId}")
	public ResponseEntity<String> delateById(@PathVariable Integer PlanId)
	{
		boolean delateById = planservice.delateById(PlanId);
		String msg="";
		if(delateById)
		{
			msg="Plan Deleated";
		}else
		{
			msg="Plan Not Delated";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@PutMapping("/statuschange/planId/{status}")
	public ResponseEntity<String> statuschange(@PathVariable Integer PlanId, @PathVariable String  Status)
	{
		boolean planStatusChange = planservice.PlanStatusChange(PlanId, Status);
		
		String msg="";
		if(planStatusChange)
		{
			msg="Status Updated";
		}else
		{
			msg="Status Not Updated";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
}

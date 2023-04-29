package com.example.demo;

import java.util.List;
import java.util.Map;


public interface PlanService {
	
	public Map<Integer,String> getplanCategors();
	
	public boolean saveplan(Plan plan);
	public List<Plan> getPlans();
	public Plan getPlanById(Integer PlanId);
	public boolean UpdatePlan(Plan plan);
	public boolean delateById(Integer PlanId);
	public boolean PlanStatusChange(Integer PlanId,String Status);

}

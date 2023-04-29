package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanServicesImpl implements PlanService {
	@Autowired
	private Plan_Repo planRepo;
	
	@Autowired
	private Plan_CategoryRepo  planCategoryRepo;

	@Override
	public Map<Integer, String> getplanCategors() {
	List<Plan_Category> findAll = planCategoryRepo.findAll();
	HashMap<Integer, String> categoryMap=new HashMap<>();
findAll.forEach(cateogry->{
	categoryMap.put(cateogry.getCategoryId(), cateogry.getCategoryName());
}
		);
		return categoryMap;
	}

	@Override
	public boolean saveplan(Plan plan) {
		
		return planRepo.save(plan)!=null ? true:false;
	}

	@Override
	public List<Plan> getPlans() {
		List<Plan> findAll = planRepo.findAll();
		return findAll;
	}

	@Override
	public Plan getPlanById(Integer PlanId) {
	Optional<Plan> findById = planRepo.findById(PlanId);
	if(findById.isPresent())
	{
		
		return findById.get();
	}
		return null;
	}

	@Override
	public boolean UpdatePlan(Plan plan) {
		planRepo.save(plan)	;
		return plan.getPLAN_ID()!=null;
	}

	
	@Override
	public boolean delateById(Integer PlanId) {
		
		
		boolean status=true;
		try {
			planRepo.deleteById(PlanId);
			status=true;
			
		}catch(Exception e)
		{
			status=false;
			e.printStackTrace();
			//System.out.println(message);)
		}
		return status;
	}

	@Override
	public boolean PlanStatusChange(Integer PlanId, String Status) {
		Optional<Plan> findById = planRepo.findById(PlanId);

		if (findById.isPresent())

		{
			Plan plan = findById.get();
			plan.setActive_Sw(Status);
			planRepo.save(plan);
			return true;
			
		}
		return false;
	}
}



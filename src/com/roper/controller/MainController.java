package com.roper.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roper.api.Mannager;
import com.roper.entity.AnimalHusbandryEntity;
import com.roper.entity.EquipmentEntity;
import com.roper.entity.GardenEntity;
import com.roper.entity.HomeEntity;
import com.roper.entity.LeagueGreenhousesEntity;
import com.roper.entity.LeagueGreenhousesOtherEntity;
import com.roper.entity.LightEntity;
import com.roper.entity.LightOtherEntity;
import com.roper.entity.LocationEntity;
import com.roper.entity.RuralEntity;
import com.roper.entity.SpringGreenhousesEntity;
import com.roper.entity.SpringGreenhousesInfoEntity;
import com.roper.utils.PackageDataUtil;

@Controller
public class MainController {

	// private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public Mannager manager;

	@RequestMapping("HomeServlet.action")
	@ResponseBody
	public String HomeServlet() {

		HomeEntity home = manager.home_query();
		JSONObject json = PackageDataUtil.packageData(home);

		return json.toString();
	}

	@RequestMapping("GardenServlet.action")
	@ResponseBody
	public String GardenServlet() {

		GardenEntity garden = manager.garden_query();
		JSONObject json = PackageDataUtil.packageData(garden);

		int arr1[] = { 0, 0, 0, 0, 0 };
		int arr2[] = { 0, 0, 0, 0, 0, 0, 0, };
		int arr3[] = { 0, 0, 0, 0, 0 };
		int arr4[] = { 0, 0, 0, 0, 0 };
		int arr5[] = { 0, 0, 0, 0, 0, 0 };
		int arr6[] = { 0, 0, 0, 0, 0, 0 };

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(arr1);
		jsonArray.add(arr2);
		jsonArray.add(arr3);
		jsonArray.add(arr4);
		jsonArray.add(arr5);
		jsonArray.add(arr6);

		json.accumulate("gardenToggle", jsonArray);

		return json.toString();
	}

	@RequestMapping("EquipmentServlet.action")
	@ResponseBody
	public String EquipmentServlet() {

		EquipmentEntity equipment = manager.equipment_query();
		JSONObject json = PackageDataUtil.packageData(equipment);

		return json.toString();
	}

	/**
	 * LeagueGreenhouses
	 */
	@RequestMapping("LeagueGreenhousesServlet.action")
	@ResponseBody
	public String LeagueGreenhousesServlet(int index) {

		LeagueGreenhousesEntity leagueGreenhouses = manager
				.leagueGreenhouses_query(index);
		JSONObject json = PackageDataUtil.packageData(leagueGreenhouses);

		return json.toString();
	}

	@RequestMapping("LeagueGreenhousesOtherServlet.action")
	@ResponseBody
	public String LeagueGreenhousesOtherServlet(int index) {

		LeagueGreenhousesOtherEntity leagueGreenhousesOther = manager
				.leagueGreenhousesOther_query(index);
		JSONObject json = PackageDataUtil.packageData(leagueGreenhousesOther);

		return json.toString();
	}

	/**
	 * Light
	 */
	@RequestMapping("LightServlet.action")
	@ResponseBody
	public String LightServlet(int index) {

		LightEntity light = manager.light_query(index);
		JSONObject json = PackageDataUtil.packageData(light);

		return json.toString();
	}

	@RequestMapping("LightOtherServlet.action")
	@ResponseBody
	public String LightOtherServlet(int index) {

		LightOtherEntity lightOther = manager.lightOther_query(index);
		JSONObject json = PackageDataUtil.packageData(lightOther);

		return json.toString();
	}

	/**
	 * Rural
	 */
	@RequestMapping("RuralServlet.action")
	@ResponseBody
	public String RuralServlet(int index) {

		RuralEntity rural = manager.rural_query(index);
		JSONObject json = PackageDataUtil.packageData(rural);

		return json.toString();
	}

	/**
	 * SpringGreenhouseInfo
	 */
	@RequestMapping("SpringGreenhousesInfoServlet.action")
	@ResponseBody
	public String SpringGreenhousesInfoServlet(int index) {

		SpringGreenhousesInfoEntity springGreenhousesInfo = manager
				.springGreenhouseInfo_query(index);
		JSONObject json = PackageDataUtil.packageData(springGreenhousesInfo);

		return json.toString();
	}

	@RequestMapping("SpringGreenhousesServlet.action")
	@ResponseBody
	public String SpringGreenhousesServlet() {

		SpringGreenhousesEntity springGreenhouses = manager
				.springGreenhouses_query();
		JSONObject json = PackageDataUtil.packageData(springGreenhouses);

		return json.toString();
	}

	@RequestMapping("AnimalHusbandryServlet.action")
	@ResponseBody
	public String AnimalHusbandryServlet() {

		AnimalHusbandryEntity animalHusbandry = manager.animalHusbandry_query();
		JSONObject json = PackageDataUtil.packageData(animalHusbandry);

		return json.toString();
	}

	@RequestMapping("A9gSignalTest.action")
	@ResponseBody
	public void hhh(HttpServletRequest request) {
		System.out.println("---------------这是A9g设备测----------------");
		manager.Location(request);
	}
	
	@RequestMapping("A9gDataQuery.action")
	@ResponseBody
	public LocationEntity hw(HttpServletRequest request){
		
		return manager.ggg(request);
	}
}
package com.roper.api;

import javax.servlet.http.HttpServletRequest;

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

public interface Mannager {
	/**
	 * IOC接口，非public
	 */
	HomeEntity home_query();

	GardenEntity garden_query();
	
	EquipmentEntity equipment_query();

	LightEntity light_query(int index);
	
	LightOtherEntity lightOther_query(int index);

	RuralEntity rural_query(int index);

	AnimalHusbandryEntity animalHusbandry_query();

	LeagueGreenhousesEntity leagueGreenhouses_query(int index);
	
	LeagueGreenhousesOtherEntity leagueGreenhousesOther_query(int index);

	SpringGreenhousesEntity springGreenhouses_query();
	
	SpringGreenhousesInfoEntity springGreenhouseInfo_query(int index);
	
	void Location(HttpServletRequest request);
	/**
	 * A9g查询接口测试
	 * @param request
	 * @return
	 */
	LocationEntity ggg(HttpServletRequest request);
	
}

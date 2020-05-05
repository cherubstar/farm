package com.roper.surface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

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
import com.roper.utils.CRUDDataUtil;

@Service
public class DataOutPut implements Mannager {

	@Override
	public HomeEntity home_query() {

		HomeEntity home = new CRUDDataUtil<HomeEntity>(HomeEntity.class)
				.query("");
		home
				.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/401");

		return home;
	}

	@Override
	public GardenEntity garden_query() {

		GardenEntity garden = new CRUDDataUtil<GardenEntity>(GardenEntity.class)
				.query("");
		garden
				.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2601");

		return garden;
	}

	@Override
	public AnimalHusbandryEntity animalHusbandry_query() {

		AnimalHusbandryEntity animalHusbandry = new AnimalHusbandryEntity();
		animalHusbandry
				.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2701");
		animalHusbandry
				.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2801");
		return animalHusbandry;
	}

	@Override
	public EquipmentEntity equipment_query() {

		EquipmentEntity equipment = new CRUDDataUtil<EquipmentEntity>(
				EquipmentEntity.class).query("");
		return equipment;
	}

	@Override
	public LeagueGreenhousesEntity leagueGreenhouses_query(int index) {

		LeagueGreenhousesEntity leagueGreenhouses = new CRUDDataUtil<LeagueGreenhousesEntity>(
				LeagueGreenhousesEntity.class).query(index);

		switch (index) {
		case 1:
			leagueGreenhouses
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/501");
			leagueGreenhouses
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/601");
			break;
		case 2:
			leagueGreenhouses
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/701");
			leagueGreenhouses
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/801");
			break;
		}

		return leagueGreenhouses;
	}

	@Override
	public LeagueGreenhousesOtherEntity leagueGreenhousesOther_query(int index) {

		LeagueGreenhousesOtherEntity leagueGreenhousesOther = new CRUDDataUtil<LeagueGreenhousesOtherEntity>(
				LeagueGreenhousesOtherEntity.class).query(index);
		return leagueGreenhousesOther;
	}

	@Override
	public LightEntity light_query(int index) {

		LightEntity light = new CRUDDataUtil<LightEntity>(LightEntity.class)
				.query(index);

		switch (index) {
		case 2:
			light
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/901");
			light
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1001");
			break;
		case 3:
			light
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1101");
			light
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1201");
			break;
		case 5:
			light
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1301");
			light
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1401");
			break;
		case 6:
			light
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1501");
			light
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1601");
			break;
		}
		return light;
	}

	@Override
	public LightOtherEntity lightOther_query(int index) {

		LightOtherEntity lightOther = new CRUDDataUtil<LightOtherEntity>(
				LightOtherEntity.class).query(index);
		return lightOther;
	}

	public RuralEntity rural_query(int index) {

		RuralEntity rural = new CRUDDataUtil<RuralEntity>(RuralEntity.class)
				.query(index);

		switch (index) {
		case 1:
			rural
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/101");
			rural
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/201");
			break;
		case 2:
			rural
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/301");
			rural
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/401");
			break;
		}
		return rural;
	}

	@Override
	public SpringGreenhousesEntity springGreenhouses_query() {

		SpringGreenhousesEntity springGreenhouses = new CRUDDataUtil<SpringGreenhousesEntity>(
				SpringGreenhousesEntity.class).query("");
		return springGreenhouses;
	}

	@Override
	public SpringGreenhousesInfoEntity springGreenhouseInfo_query(int index) {

		SpringGreenhousesInfoEntity springGreenhousesInfo = new CRUDDataUtil<SpringGreenhousesInfoEntity>(
				SpringGreenhousesInfoEntity.class).query(index);

		if (1 <= index && index <= 5) {
			springGreenhousesInfo
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1701");
			springGreenhousesInfo
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1801");
		} else if (6 <= index && index <= 10) {
			springGreenhousesInfo
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/1901");
			springGreenhousesInfo
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2001");
		} else if (11 <= index && index <= 15) {
			springGreenhousesInfo.setCameraUrl("");
			springGreenhousesInfo.setCameraUrl2("");
		} else if (16 <= index && index <= 20) {
			springGreenhousesInfo
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2101");
			springGreenhousesInfo
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2201");
		} else if (21 <= index && index <= 25) {
			springGreenhousesInfo
					.setCameraUrl("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2301");
			springGreenhousesInfo
					.setCameraUrl2("rtsp://admin:a1234567@221.176.198.10:50228/Streaming/Channels/2401");
		} else {

		}

		return springGreenhousesInfo;
	}

	@Override
	public void Location(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String timestamp = request.getParameter("timestamp");
		String lat = request.getParameter("lat");
		String lon = request.getParameter("lon");
		LocationEntity Le = new LocationEntity();
		Le.setId(id);
		Le.setTimestamp(timestamp);
		Le.setLat(lat);
		Le.setLon(lon);
		System.out.println(Le.toString());
		CRUDDataUtil.save(Le);
	}

	@Override
	public LocationEntity ggg(HttpServletRequest request) {
//		String str=request.getParameter("equipmentId");
		LocationEntity location = new CRUDDataUtil<LocationEntity>(LocationEntity.class).query("");
		return location;
	}
}
package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_theme;
import com.entities.skill;
import com.entities.user;

@Component
public class MissionLoader implements MissionLoaderInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<mission> loadAllMissionOnSearch(Filters filters) {

		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
		if (filters.getSearchedKeyword() != "") {
			c.add(Restrictions.like("title", "%" + filters.getSearchedKeyword() + "%"));
		}
		if (filters.getCountry_id() != 0) {
			c.add(Restrictions.eq("country.country_id", filters.getCountry_id()));
		}
		if (filters.getSearchedcities().size() > 0) {
			c.add(Restrictions.in("city.city_id", filters.getSearchedcities()));
		}
		if (filters.getSearchedthemes().size() > 0) {
			c.add(Restrictions.in("mission_theme.mission_theme_id", filters.getSearchedthemes()));
		}
		if (filters.getSearchedskills().size() > 0) {
			c.createAlias("mission_skills", "ms");
			c.add(Restrictions.in("ms.skill.skill_id", filters.getSearchedskills()));
		}
		if (filters.getSortby().equals("Newest")) {
			c.addOrder(Order.asc("created_at"));
		}
		if (filters.getSortby().equals("Oldest")) {
			c.addOrder(Order.desc("created_at"));
		}
		int firstresultcount = ((filters.getCurrentPage() - 1) * 3) + 3;
//		if(filters.getCurrentPage()!=1) {
//			firstresultcount++;
//		}
		c.setFirstResult(firstresultcount);
		c.setMaxResults(3);
//		if (c.list().size() < 3) {
//			int setMax = 3 + (3 - c.list().size());
//	    	System.out.println("setmax:"+setMax);
//		}
		return c.list();
	}

	public Long countAllMission(Filters filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
		if (filters.getSearchedKeyword() != "") {
			c.add(Restrictions.like("title", "%" + filters.getSearchedKeyword() + "%"));
		}
		if (filters.getCountry_id() != 0) {
			c.add(Restrictions.eq("country.country_id", filters.getCountry_id()));
		}
		if (filters.getSearchedcities().size() > 0) {
			c.add(Restrictions.in("city.city_id", filters.getSearchedcities()));
		}
		if (filters.getSearchedthemes().size() > 0) {
			c.add(Restrictions.in("mission_theme.mission_theme_id", filters.getSearchedthemes()));
		}
		if (filters.getSearchedskills().size() > 0) {
			c.createAlias("mission_skills", "ms");
			c.add(Restrictions.in("ms.skill.skill_id", filters.getSearchedskills()));
		}
		if (filters.getSortby().equals("Newest")) {
			c.addOrder(Order.asc("created_at"));
		}
		if (filters.getSortby().equals("Oldest")) {
			c.addOrder(Order.desc("created_at"));
		}
		c.setProjection(Projections.countDistinct("mission_id"));
		long result = (long) c.uniqueResult();
		return result;
	}

	public List<country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(country.class);
	}

	public List<city> loadCityOfCountry(int country_id) {
		String que = "from city where country_id=:country_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("country_id", country_id);
		List<city> mylist = q.list();
		return mylist;
	}

	public List<mission_theme> loadAllThemes() {
		return this.hibernateTemplate.loadAll(mission_theme.class);
	}

	public List<mission> loadAllMission() {
		String que = "from mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setFirstResult(0);
		q.setMaxResults(10);
		return q.list();
	}

	public List<skill> loadAllSkillOnSearch() {
		return this.hibernateTemplate.loadAll(skill.class);
	}

	public List<user> loadAllUserOnSearch() {
		return this.hibernateTemplate.loadAll(user.class);
	}

	@Transactional
	public void save(favourite_mission fv) {
		this.hibernateTemplate.save(fv);
		System.out.println("saved");
	}
	
	@Transactional
	public void delete(favourite_mission fv) {
		this.hibernateTemplate.delete(fv);
		System.out.println("removed");
	}

	public List<mission> loadrelatedmission(mission mission1,city city, country country, mission_theme mission_theme) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria ccity = s.createCriteria(mission.class);
		Criteria ccountry = s.createCriteria(mission.class);
		Criteria ctheme = s.createCriteria(mission.class);
		
		ccity.setResultTransformer(ccity.DISTINCT_ROOT_ENTITY);
		ccountry.setResultTransformer(ccity.DISTINCT_ROOT_ENTITY);
		ctheme.setResultTransformer(ccity.DISTINCT_ROOT_ENTITY);
		
		ccity.add(Restrictions.ne("mission_id", mission1.getMission_id()));
		ccity.add(Restrictions.eq("city.city_id", city.getCity_id()));
		if(ccity.list().size()>0) {
			return ccity.list();
		}
		
		ccountry.add(Restrictions.ne("mission_id", mission1.getMission_id()));
		ccountry.add(Restrictions.eq("country.country_id", country.getCountry_id()));
		if(ccountry.list().size()>0) {
			return ccountry.list();
		}

		ctheme.add(Restrictions.ne("mission_id", mission1.getMission_id()));
		ctheme.add(Restrictions.eq("mission_theme.mission_theme_id",mission_theme.getMission_theme_id()));
		if(ctheme.list().size()>0) {
			return ctheme.list();
		}
		return null;
		
	}

	public List<mission> getLikedMission(user user) {
		String que = "from favourite_mission where user_id=:user_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		List<mission> mylist=q.list();
		return mylist;
	}

}

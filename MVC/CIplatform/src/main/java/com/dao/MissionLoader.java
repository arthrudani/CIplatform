package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dto.Filters;
import com.entities.city;
import com.entities.country;
import com.entities.mission;
import com.entities.mission_skill;
import com.entities.mission_theme;
import com.entities.skill;

@Component
public class MissionLoader implements MissionLoaderInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<mission> loadAllMissionOnSearch(Filters filters) {
		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
	    if(filters.getSearchedKeyword()!="") {
	    	c.add(Restrictions.like("title", "%" +filters.getSearchedKeyword()+ "%"));
	    }
	    
	    if(filters.getCountry_id()!= 0) {
	    	c.add(Restrictions.eq("country.country_id",filters.getCountry_id()));
	    }
	    if(filters.getSearchedcities().size()>0) {
	    	c.add(Restrictions.in("city.city_id",filters.getSearchedcities()));
	    }
	    if(filters.getSearchedthemes().size()>0) {
	    	c.add(Restrictions.in("mission_theme.mission_theme_id",filters.getSearchedthemes()));
	    }
	    if(filters.getSearchedskills().size()>0) {
	    	c.createAlias("mission_skills", "ms");
		    c.add(Restrictions.in("ms.skill.skill_id",filters.getSearchedskills()));
	    }
	    if(filters.getSortby().equals("Newest")) {
	    	c.addOrder(Order.asc("created_at"));
	    }
	    if(filters.getSortby().equals("Oldest")) {
    		c.addOrder(Order.desc("created_at"));
    }
		return c.list();

		
	}

	public List<country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(country.class);
	}

	public List<city> loadCityOfCountry(int country_id) {
		String que="from city where country_id=:country_id"; 
		 Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		 q.setParameter("country_id",country_id);
		 List<city> mylist=q.list();
		return mylist;
	}

	public List<mission_theme> loadAllThemes() {
		return this.hibernateTemplate.loadAll(mission_theme.class);
	}

	public List<mission> loadAllMission() {
		String que="from mission";
		Query q=hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setFirstResult(0);
		q.setMaxResults(10);
		return q.list();
	}

	public List<skill> loadAllSkillOnSearch() {
		return this.hibernateTemplate.loadAll(skill.class);
	}



}

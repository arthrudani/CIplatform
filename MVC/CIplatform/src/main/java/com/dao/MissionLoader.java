package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import com.entities.comment;
import com.entities.country;
import com.entities.favourite_mission;
import com.entities.mission;
import com.entities.mission_application;
import com.entities.mission_application.approval;
import com.entities.mission_document;
import com.entities.mission_rating;
import com.entities.mission_skill;
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
		c.setFirstResult(firstresultcount);
		c.setMaxResults(3);
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
	}
	
	@Transactional
	public void delete(favourite_mission fv) {
		this.hibernateTemplate.delete(fv);
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

	public int getRatingCount(mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria avg = s.createCriteria(mission.class);
		avg.add(Restrictions.eq("mission", mission));
		
		return 0;
	}

	public Double getAverageRatings(mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = s.createCriteria(mission_rating.class);
		criteria.add(Restrictions.eq("mission", mission));
		if(criteria.list().size()==0) {
			return (double) 0;
		}
		criteria.setProjection(Projections.avg("rating"));
		List listAvgSalary = criteria.list();
		
		Double avgSalary = (Double)listAvgSalary.get(0);
		
		return avgSalary;
	}

	@Transactional
	public void save(mission_rating mission_rating1) {
		this.hibernateTemplate.save(mission_rating1);
		System.out.println("saved");
		
	}
	@Transactional
	public void saveorupdate(mission_rating mission_rating1) {
		this.hibernateTemplate.saveOrUpdate(mission_rating1);
		System.out.println("saved");
		
	}
	@Transactional
	public void delete(mission_rating mission_rating1) {
		this.hibernateTemplate.delete(mission_rating1);
		System.out.println("deleted");
		
	}

	public List<comment> getAllComments(mission mission) {
		String que= "from comment where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<comment> mylist=q.list();
		return mylist;
	}
	
	public List<mission_document> loadAllDocuments(mission mission) {
		String que= "from mission_document where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<mission_document> mylist=q.list();
		return mylist;
	}
	
	public List<mission_skill> loadMissionSkills(mission mission) {
		String que= "from mission_skill where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<mission_skill> mylist=q.list();
		return mylist;
	}

	
	public List<mission_application> loadRecentVolunteers(mission mission,int currentPage) {		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission_application.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("approval_status", approval.ONE));
		c.add(Restrictions.eq("mission.mission_id", mission.getMission_id()));
		int firstresultcount=0;
		firstresultcount = ((currentPage-1) * 3) + 3;
		System.out.println("first firstresultcount:"+firstresultcount);
		c.setFirstResult(firstresultcount);
		c.setMaxResults(3);
		System.out.println("current pageeeeeeeeeeeeeee:"+currentPage);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx:"+c.list().size());
		return c.list();
	}
	
	public int loadTotalRecentVolunteers(mission mission) {		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(mission_application.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("approval_status", approval.ONE));
		c.add(Restrictions.eq("mission.mission_id", mission.getMission_id()));
		return c.list().size();
	}
}

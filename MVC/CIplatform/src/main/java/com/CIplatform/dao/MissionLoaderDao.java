package com.CIplatform.dao;

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

import com.CIplatform.dto.Filters;
import com.entities.City;
import com.entities.Comment;
import com.entities.Country;
import com.entities.FavouriteMission;
import com.entities.Mission;
import com.entities.Mission.mission_type;
import com.entities.MissionApplication;
import com.entities.MissionDocument;
import com.entities.MissionRating;
import com.entities.MissionSkill;
import com.entities.MissionTheme;
import com.entities.Skill;
import com.entities.Skill.Status;
import com.entities.User;
import com.entities.MissionApplication.approval;

@Component
public class MissionLoaderDao implements MissionLoaderInterface {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Mission> loadAllMissionOnSearch(Filters filters) {

		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
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
		if (filters.getSortby().equals("LowestAvailable")) {
			c.addOrder(Order.asc("seatsLeft"));
			c.add(Restrictions.in("mission_type", mission_type.TIME));
		}
		if (filters.getSortby().equals("HighestAvailable")) {
			c.addOrder(Order.desc("seatsLeft"));
			c.add(Restrictions.in("mission_type", mission_type.TIME));
		}
		if (filters.getSortby().equals("RegistrationDeadline")) {
			c.addOrder(Order.desc("deadline"));
			c.add(Restrictions.in("mission_type", mission_type.TIME));
		}
		int firstresultcount = ((filters.getCurrentPage() - 1) * 3) + 3;
		c.setFirstResult(firstresultcount);
		c.setMaxResults(3);
		return c.list();
	}

	public Long countAllMission(Filters filters) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Mission.class);
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

	public List<Country> loadListOfCountry() {
		return this.hibernateTemplate.loadAll(Country.class);
	}

	public List<City> loadCityOfCountry(int country_id) {
		String que = "from City where country_id=:country_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("country_id", country_id);
		List<City> mylist = q.list();
		return mylist;
	}

	public List<MissionTheme> loadAllThemes() {
		String que = "from MissionTheme where status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status", "ACTIVE");
		return q.list();
	}

	public List<Mission> loadAllMission() {
		String que = "from Mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setFirstResult(0);
		q.setMaxResults(10);
		return q.list();
	}

	public List<Skill> loadAllSkillOnSearch() {
		String que = "from Skill where status=:status";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("status", Status.ACTIVE);
		return q.list();
	}

	public List<User> loadAllUserOnSearch() {
		return this.hibernateTemplate.loadAll(User.class);
	}

	@Transactional
	public void save(FavouriteMission fv) {
		this.hibernateTemplate.save(fv);
	}
	
	@Transactional
	public void delete(FavouriteMission fv) {
		this.hibernateTemplate.delete(fv);
	}

	public List<Mission> loadrelatedmission(Mission mission1,City city, Country country, MissionTheme mission_theme) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria ccity = s.createCriteria(Mission.class);
		Criteria ccountry = s.createCriteria(Mission.class);
		Criteria ctheme = s.createCriteria(Mission.class);
		
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

	public List<Mission> getLikedMission(User user) {
		String que = "from FavouriteMission where user_id=:user_id";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user_id", user.getUser_id());
		List<Mission> mylist=q.list();
		return mylist;
	}

	public int getRatingCount(Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria avg = s.createCriteria(Mission.class);
		avg.add(Restrictions.eq("mission", mission));
		
		return 0;
	}

	public Double getAverageRatings(Mission mission) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = s.createCriteria(MissionRating.class);
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
	public void save(MissionRating mission_rating1) {
		this.hibernateTemplate.save(mission_rating1);
		System.out.println("saved");
		
	}
	@Transactional
	public void saveorupdate(MissionRating mission_rating1) {
		this.hibernateTemplate.saveOrUpdate(mission_rating1);
		System.out.println("saved");
		
	}
	@Transactional
	public void delete(MissionRating mission_rating1) {
		this.hibernateTemplate.delete(mission_rating1);
		System.out.println("deleted");
		
	}

	public List<Comment> getAllComments(Mission mission) {
		String que= "from Comment where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<Comment> mylist=q.list();
		return mylist;
	}
	
	public List<MissionDocument> loadAllDocuments(Mission mission) {
		String que= "from MissionDocument where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<MissionDocument> mylist=q.list();
		return mylist;
	}
	
	public List<MissionSkill> loadMissionSkills(Mission mission) {
		String que= "from MissionSkill where mission=:mission";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		List<MissionSkill> mylist=q.list();
		return mylist;
	}

	
	public List<MissionApplication> loadRecentVolunteers(Mission mission,int currentPage) {		
		int firstresultcount=0;
		firstresultcount = ((currentPage-1) * 3) + 3;
		String que= "from MissionApplication where mission=:mission and approval_status=:as";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("mission",mission);
		q.setParameter("as",approval.ONE);
		q.setFirstResult(firstresultcount);
		q.setMaxResults(3);
		List<MissionApplication> mylist=q.list();
		return mylist;
	}
	
	public int loadTotalRecentVolunteers(Mission mission) {		
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Criteria c = s.createCriteria(MissionApplication.class);
		c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
		c.add(Restrictions.eq("approval_status", approval.ONE));
		c.add(Restrictions.eq("mission.mission_id", mission.getMission_id()));
		return c.list().size();
	}
}

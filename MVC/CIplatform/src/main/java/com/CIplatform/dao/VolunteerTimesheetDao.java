package com.CIplatform.dao;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.CIplatform.dto.ShareTimesheetDto;
import com.entities.Mission;
import com.entities.Mission.mission_type;
import com.entities.Timesheet;
import com.entities.Timesheet.approval;
import com.entities.User;

@Component
public class VolunteerTimesheetDao implements VolunteerTimesheetDaoInterface{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Timesheet> loadAllMissionByTimesheet(User user) {
		String que = "from Timesheet where user=:user and status=:status and (deletedAt is null)";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user", user);
		q.setParameter("status", approval.PUBLISHED);
		return q.list();
	}

	@Transactional
	public void saveTimesheet(ShareTimesheetDto shareTimesheetDto) {
		Mission mission=this.hibernateTemplate.get(Mission.class, shareTimesheetDto.getChekedMission());
		User user=this.hibernateTemplate.get(User.class, shareTimesheetDto.getUser_id());
		Timesheet timesheet1=this.hibernateTemplate.get(Timesheet.class, shareTimesheetDto.getTimesheetId());
		
		if(timesheet1==null) {
			if(mission.getMission_type()==mission_type.TIME) {
				LocalTime ttime=LocalTime.of(shareTimesheetDto.getHours(),shareTimesheetDto.getMinutes());
				Timesheet timesheet=new Timesheet();
				timesheet.setAction(0);
				timesheet.setCreatedAt(new Date());
				timesheet.setDateVolunteered(shareTimesheetDto.getDate());
				timesheet.setMission(mission);
				timesheet.setNotes(shareTimesheetDto.getMessage());
				timesheet.setStatus(approval.PENDING);
				timesheet.setUser(user);
				timesheet.setTime(ttime);
				this.hibernateTemplate.save(timesheet);
			}
			else {
				Timesheet timesheet=new Timesheet();
				timesheet.setAction(shareTimesheetDto.getAction());
				timesheet.setCreatedAt(new Date());
				timesheet.setDateVolunteered(shareTimesheetDto.getDate());
				timesheet.setMission(mission);
				timesheet.setNotes(shareTimesheetDto.getMessage());
				timesheet.setStatus(approval.PENDING);
				timesheet.setUser(user);
				this.hibernateTemplate.save(timesheet);
			}
		}
		else {
			System.out.println(shareTimesheetDto.getMessage());
			if(mission.getMission_type()==mission_type.TIME) {
				LocalTime ttime=LocalTime.of(shareTimesheetDto.getHours(),shareTimesheetDto.getMinutes());
				timesheet1.setAction(0);
				timesheet1.setCreatedAt(new Date());
				timesheet1.setDateVolunteered(shareTimesheetDto.getDate());
				timesheet1.setMission(mission);
				timesheet1.setNotes(shareTimesheetDto.getMessage());
				timesheet1.setStatus(approval.PUBLISHED);
				timesheet1.setUser(user);
				timesheet1.setTime(ttime);
				this.hibernateTemplate.saveOrUpdate(timesheet1);
			}
			else {
				timesheet1.setAction(shareTimesheetDto.getAction());
				timesheet1.setCreatedAt(new Date());
				timesheet1.setDateVolunteered(shareTimesheetDto.getDate());
				timesheet1.setMission(mission);
				timesheet1.setNotes(shareTimesheetDto.getMessage());
				timesheet1.setStatus(approval.PUBLISHED);
				timesheet1.setUser(user);
				this.hibernateTemplate.saveOrUpdate(timesheet1);
			}
		}
		
	}

	public List<Mission> loadApprovedMissionsTimebased(User user) {
		String que = "from MissionApplication where user=:user and approval_status=:status and mission.mission_type=:type";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user", user);
		q.setParameter("status", com.entities.MissionApplication.approval.ONE);
		q.setParameter("type", mission_type.TIME);
		return q.list();
	}

	public List<Mission> loadApprovedMissionsGoalbased(User user) {
		String que = "from MissionApplication where user=:user and approval_status=:status and mission.mission_type=:type";
		Query q = hibernateTemplate.getSessionFactory().openSession().createQuery(que);
		q.setParameter("user", user);
		q.setParameter("status", com.entities.MissionApplication.approval.ONE);
		q.setParameter("type", mission_type.GOAL);
		return q.list();
	}
	
	@Transactional
	public void deleteTimesheet(int tid) {
		Timesheet timesheet1=this.hibernateTemplate.get(Timesheet.class, tid);
		if(timesheet1!=null) {
			timesheet1.setDeletedAt(new Date());
			this.hibernateTemplate.saveOrUpdate(timesheet1);
		}
	}
}

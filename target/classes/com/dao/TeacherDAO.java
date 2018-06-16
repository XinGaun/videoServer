package com.dao;

import java.util.List;

import com.entity.RightDomain;
import com.entity.TeacherDomain;

public interface TeacherDAO
{


	public int addTeacher(TeacherDomain TeacherDomain);

	public int deleteTeacher(TeacherDomain TeacherDomain);

	public int modifyTeacher(TeacherDomain TeacherDomain);

	public List<TeacherDomain> queryListTeacher(TeacherDomain TeacherDomain);

	public int queryTeacherCount(TeacherDomain TeacherDomain);

	public List<RightDomain> queryTeacherRight(String user_id);
}

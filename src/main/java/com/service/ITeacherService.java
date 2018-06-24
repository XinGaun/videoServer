package com.service;

import com.entity.TeacherDomain;
import com.util.PaginationBean;
import com.util.ResponseInfo;

import java.util.List;

public interface ITeacherService
{

	public ResponseInfo addTeacher(TeacherDomain TeacherDomain);

	public int deleteTeacher(TeacherDomain TeacherDomain);

	public int modifyTeacher(TeacherDomain TeacherDomain);

	public List<TeacherDomain> queryListTeacher(TeacherDomain TeacherDomain,PaginationBean page);

	public TeacherDomain searchSingleTeacher(TeacherDomain TeacherDomain);

	public int  queryTeacherCount(TeacherDomain TeacherDomain);
}

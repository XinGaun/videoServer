package com.service;

import java.util.List;

import com.entity.TeacherDomain;
import com.util.PaginationBean;
import com.util.ResponseInfo;

public interface ITeacherService
{

	public ResponseInfo addTeacher(TeacherDomain TeacherDomain);

	public int deleteTeacher(TeacherDomain TeacherDomain);

	public int modifyTeacher(TeacherDomain TeacherDomain);

	public List<TeacherDomain> queryListTeacher(TeacherDomain TeacherDomain,PaginationBean page);

	public TeacherDomain searchSingleTeacher(TeacherDomain TeacherDomain);

	public int  queryTeacherCount(TeacherDomain TeacherDomain);
}

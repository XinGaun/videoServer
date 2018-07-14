package com.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.TeacherDAO;
import com.entity.RightDomain;
import com.entity.TeacherDomain;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private TeacherDAO teacherDao;
	
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection PrincipalCollection) {
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();        
		 TeacherDomain principal = (TeacherDomain)PrincipalCollection.getPrimaryPrincipal();//获取登录的用户名   
	        List<RightDomain> rightList = teacherDao.queryTeacherRight(principal.getTeacher_id());
	        for (RightDomain param : rightList) {
				info.addStringPermission(param.getRight_name());
			}
	        return info;
	}

	/**
	 * 用户验证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 //1. token 中获取登录的 username! 注意不需要获取password.
        Object principal = token.getPrincipal();
        //2. 利用 username 查询数据库得到用户的信息. 
        TeacherDomain user = new TeacherDomain();
        user.setTeacher_phone((String)principal);
       List<TeacherDomain> listTeacher = teacherDao.queryListTeacher(user);
        if(listTeacher == null || listTeacher.size() == 0)
        	//用户名不存在
            return null;
        else{
        	TeacherDomain result = listTeacher.get(0);
	        String credentials = result.getTeacher_pwd();
	        //当前 Realm 的name
	        String realmName = getName();
	        //返回值实例化
	        SimpleAuthenticationInfo info = 
	                new SimpleAuthenticationInfo(result, credentials, realmName);
	        return info;
        }
	}
	
	//init-method 配置. 
    public void setCredentialMatcher(){
        HashedCredentialsMatcher  credentialsMatcher = new HashedCredentialsMatcher();    
        credentialsMatcher.setHashAlgorithmName("MD5");//MD5算法加密
        credentialsMatcher.setHashIterations(1024);//1024次循环加密      
        setCredentialsMatcher(credentialsMatcher);
    }

}

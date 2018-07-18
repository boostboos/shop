package com.legendary.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.relation.Role;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.legendary.entity.Admins;
import com.legendary.entity.Roles;
import com.legendary.service.RoleService;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}
	RoleService roleService = new RoleService();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

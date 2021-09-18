package controller.viewHelper.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.client.DomainEntity;
import domain.client.Result;

public interface IViewHelper {
	public DomainEntity getEntity(HttpServletRequest request);

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}	

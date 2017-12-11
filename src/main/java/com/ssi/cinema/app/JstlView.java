package com.ssi.cinema.app;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class JstlView extends InternalResourceView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Determine the path for the request dispatcher.
		String dispatcherPath = prepareForRendering(request, response);
		
		// set original view being asked for as a request parameter
		request.setAttribute("content", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		requestDispatcher.include(request, response);
		
	}
	
}
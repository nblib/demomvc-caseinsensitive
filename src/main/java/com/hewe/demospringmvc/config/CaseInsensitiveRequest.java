package com.hewe.demospringmvc.config;

import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;

public class CaseInsensitiveRequest extends HttpServletRequestWrapper {


    private LinkedCaseInsensitiveMap<String> parms = new LinkedCaseInsensitiveMap();

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public CaseInsensitiveRequest(HttpServletRequest request) {
        super(request);
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            parms.put(name, name);
        }
    }


    @Override
    public String getParameter(String name) {

        return super.getParameter(parms.get(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(parms.get(name));
    }
}

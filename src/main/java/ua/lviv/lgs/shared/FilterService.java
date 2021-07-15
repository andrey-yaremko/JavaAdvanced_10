package ua.lviv.lgs.shared;
import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import ua.lviv.lgs.domain.Role;

public class FilterService {
    private static FilterService filterService;

    private FilterService() {
    }

    public static FilterService getFilterService() {
        if (filterService == null) {
            filterService = new FilterService();
        }

        return filterService;
    }

    public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain,
                                   List<Role> userRole) throws IOException, ServletException {

        try {
            HttpSession session = ((HttpServletRequest) request).getSession();
            Role role = Role.valueOf((String) session.getAttribute("role"));

            if (role != null && userRole.contains(role)) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}

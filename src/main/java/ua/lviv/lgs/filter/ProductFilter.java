package ua.lviv.lgs.filter;

import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/product")
public class ProductFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList(Role.USER));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

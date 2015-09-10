package thjug.springboot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PermissionFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest req
            , final ServletResponse res
            , final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest http = (HttpServletRequest) req;
        final HttpSession session = http.getSession();

        final String u = (String) session.getAttribute("username");

        if (u != null) {
            log.info("Access with Account {}", u);
            chain.doFilter(req, res);
        } else {
            final HttpServletResponse response = (HttpServletResponse) res;
            response.sendRedirect("/login");
        }
    }

    @Override
    public void init(final FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}

package thjug.springboot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnalyticFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest req
            , final ServletResponse res
            , final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest http = (HttpServletRequest) req;

        log.info("{} {}", http.getMethod(), http.getRequestURI());

        chain.doFilter(req, res);
    }

    @Override
    public void init(final FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}

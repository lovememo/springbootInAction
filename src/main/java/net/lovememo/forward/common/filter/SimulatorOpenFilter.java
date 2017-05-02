package net.lovememo.forward.common.filter;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lovememo on 17-5-2.
 */
public class SimulatorOpenFilter implements Filter {
    private static final Logger log = (Logger) LoggerFactory.getLogger(SimulatorOpenFilter.class);

    private boolean openFlag = false;

    public SimulatorOpenFilter(boolean openFlag) {
        this.openFlag = openFlag;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(openFlag) {
            chain.doFilter(request, response);
            return;
        }
        try {
            String uri = ((HttpServletRequest) request).getRequestURI();
            if (uri.endsWith("forbidden.html")
                    || uri.endsWith("css")
                    || uri.endsWith("png")
                    || uri.endsWith("js")
                    || uri.endsWith("ttf")
                    || uri.endsWith("eot")
                    || uri.endsWith("woff")) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("errorMsg", "职业年金前置系统接口手工处理功能未开启，请确认");                                        // 为request对象添加参数
                RequestDispatcher dispatcher = request.getRequestDispatcher("/simulator/forbidden.html");    // 使用req对象获取RequestDispatcher对象
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return;
        }
    }

    @Override
    public void destroy() {

    }
}

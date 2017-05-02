package net.lovememo.forward.common.config;

import ch.qos.logback.classic.Logger;
import net.lovememo.forward.common.filter.SimulatorOpenFilter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lovememo on 17-5-2.
 */
@SuppressWarnings("unused")
@Configuration
public class FilterConfig {
    private static final Logger log = (Logger) LoggerFactory.getLogger(FilterConfig.class);

    @Value("${simulator.openFlag}")
    private String openFlag;

    private boolean isOpen() {
        try {
            return "1".equals(this.openFlag);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
    /**
     * 用于校验前置系统接口人工处理功能页面是否开放
     * @return
     */
    @Bean
    public FilterRegistrationBean filterSimulationOpenBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addUrlPatterns("/simulator/*");
        registrationBean.setFilter(new SimulatorOpenFilter(this.isOpen()));
        registrationBean.setOrder(1);
        return registrationBean;
    }
}

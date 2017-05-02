package net.lovememo.forward.simulator.service.impl;

import ch.qos.logback.classic.Logger;
import net.lovememo.forward.simulator.service.ISimulatorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by lovememo on 17-5-2.
 */
@Service
public class SimulatorService implements ISimulatorService{
    private static final Logger log = (Logger) LoggerFactory.getLogger(SimulatorService.class);

    //开启标志
    @Value("${simulator.openFlag}")
    private String openFlag;

    public boolean getOpenFlag() {
        try {
            return "1".equals(openFlag);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }
}

package net.lovememo.forward.simulator.service;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * Created by lovememo on 17-5-2.
 */
@Service
public interface ISimulatorService {

    /**
     * 手工处理是否开启标志 1-是 0-否
     * @return
     */
    public boolean getOpenFlag();

}

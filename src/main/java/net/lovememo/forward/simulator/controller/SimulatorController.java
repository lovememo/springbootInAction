package net.lovememo.forward.simulator.controller;

import ch.qos.logback.classic.Logger;
import net.lovememo.forward.simulator.service.ISimulatorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lovememo on 17-5-2.
 */
@Controller
public class SimulatorController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(SimulatorController.class);

    @Autowired
    private ISimulatorService simulatorService;

    @RequestMapping(value = "/simulator", method = {
            RequestMethod.GET, RequestMethod.POST})
    public String simulator(Model model) {
        model.addAttribute("openFlag", this.simulatorService.getOpenFlag());
        return "simulator";
    }

}

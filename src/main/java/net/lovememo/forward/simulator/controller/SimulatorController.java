package net.lovememo.forward.simulator.controller;

import ch.qos.logback.classic.Logger;
import net.lovememo.forward.simulator.service.ISimulatorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lovememo on 17-5-2.
 */
@Controller
@SuppressWarnings("unused")
public class SimulatorController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(SimulatorController.class);

    @Autowired
    private ISimulatorService simulatorService;

    @RequestMapping(value = "/simulator")
    public String simulator(Model model) {
        if(this.simulatorService.getOpenFlag()) {
            return "simulator/dashboard";
        } else {
            model.addAttribute("errorMsg", "职业年金前置系统接口手工处理功能未开启！");
            return "simulator/forbidden";
        }
    }

    //one html file one request
    @RequestMapping(value = "/simulator/ajax/notifications.html")
    public String notifications() {
        return "simulator/ajax/notifications";
    }

    @RequestMapping(value = "/simulator/buttons.html")
    public String buttons() {
        return "simulator/buttons";
    }

    @RequestMapping(value = "/simulator/calendar.html")
    public String calendar() {
        return "simulator/calendar";
    }

    @RequestMapping(value = "/simulator/dashboard.html")
    public String dashboard() {
        return "simulator/dashboard";
    }

    @RequestMapping(value = "/simulator/editor.html")
    public String editor() {
        return "simulator/editor";
    }

    @RequestMapping(value = "/simulator/elements.html")
    public String elements() {
        return "simulator/elements";
    }

    @RequestMapping(value = "/simulator/forbidden.html")
    public String forbidden() {
        return "simulator/forbidden";
    }

    @RequestMapping(value = "/simulator/forms.html")
    public String forms() {
        return "simulator/forms";
    }

    @RequestMapping(value = "/simulator/index.html")
    public String index() {
        return "simulator/index";
    }

    @RequestMapping(value = "/simulator/internal.html")
    public String internal() {
        return "simulator/internal";
    }

    @RequestMapping(value = "/simulator/manageblog.html")
    public String manageblog() {
        return "simulator/manageblog";
    }

    @RequestMapping(value = "/simulator/messages.html")
    public String messages() {
        return "simulator/messages";
    }

    @RequestMapping(value = "/simulator/newpost.html")
    public String newpost() {
        return "simulator/newpost";
    }

    @RequestMapping(value = "/simulator/newsfeed.html")
    public String newsfeed() {
        return "simulator/newsfeed";
    }

    @RequestMapping(value = "/simulator/notfound.html")
    public String notfound() {
        return "simulator/notfound";
    }

    @RequestMapping(value = "/simulator/offline.html")
    public String offline() {
        return "simulator/offline";
    }

    @RequestMapping(value = "/simulator/photo.html")
    public String photo() {
        return "simulator/photo";
    }

    @RequestMapping(value = "/simulator/productlist.html")
    public String productlist() {
        return "simulator/productlist";
    }

    @RequestMapping(value = "/simulator/profile.html")
    public String profile() {
        return "simulator/profile";
    }

    @RequestMapping(value = "/simulator/reports.html")
    public String reports() {
        return "simulator/reports";
    }

    @RequestMapping(value = "/simulator/support.html")
    public String support() {
        return "simulator/support";
    }

    @RequestMapping(value = "/simulator/tables.html")
    public String tables() {
        return "simulator/tables";
    }

    @RequestMapping(value = "/simulator/typography.html")
    public String typography() {
        return "simulator/typography";
    }

    @RequestMapping(value = "/simulator/widgets.html")
    public String widgets() {
        return "simulator/widgets";
    }

    @RequestMapping(value = "/simulator/wizard.html")
    public String wizard() {
        return "simulator/wizard";
    }

}

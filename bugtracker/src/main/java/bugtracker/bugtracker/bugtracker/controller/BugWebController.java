import bugtracker.bugtracker.bugtracker.repository.BugRepository;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BugWebController {

    @Autowired
    private BugRepository bugRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bugs", bugRepository.findAll());
        return "index";
    }

    @GetMapping("/add-bug")
    public String addBugForm() {
        return "add-bug";
    }

    @PostMapping("/submit-bug")
    public <Bug> String submitBug(@RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam String status,
                                  @RequestParam String severity,
                                  @RequestParam String reporter,
                                  @RequestParam String assignee) {
        Bug bug = new Bug();
        bug.setTitle(title);
        bug.toString(description);
        bug.setStatus(status);
        bug.setSeverity(severity);
        bug.setReporter(reporter);
        bug.setAssignee(assignee);
        bugRepository.save(bug);
        return "redirect:/";
    }
}

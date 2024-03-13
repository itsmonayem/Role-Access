package com.example.role_access.controller;

import com.example.role_access.Status;
import com.example.role_access.entity.Application;
import com.example.role_access.entity.ApplicationHistory;
import com.example.role_access.entity.User;
import com.example.role_access.service.AccessService;
import com.example.role_access.service.ApplicationService;
import com.example.role_access.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class RoleAccessController {
    private final UserService userService;
    private final ApplicationService applicationService;
    private final AccessService accessService;

    @ModelAttribute
    public void userDetails(Model model) {
        User user = userService.getLoggedInUser();
        model.addAttribute("user_name", user.getName());
        model.addAttribute("user_type", user.getRole());
    }


    @GetMapping("/user-A/")
    public String home(Model model) {
        User user = userService.getLoggedInUser();

        List<Application> applications = this.applicationService.getApplicationByUser(user);

        model.addAttribute("applicationList",applications);
        return "UserA/home";
    }


    @PostMapping("/user-A/application")
    public String initiatedApplication(@ModelAttribute Application application) {

        application.setStatus(Status.INITIATED);
        application.setUser(userService.getLoggedInUser());
        application.getHistories().add(new ApplicationHistory(Status.INITIATED, userService.getLoggedInUser(), LocalTime.now()));
        this.applicationService.save(application);

        return "redirect:/user-A/";
    }


    @GetMapping("/user-B/")
    public String userB_Home(Model model) {
        List<Application> applications = this.applicationService.getAllApplication();
        model.addAttribute("applicationList",applications);
        return "UserB/home";
    }


    @GetMapping("/user-B/accept/{id}")
    public String validateByUserB(@PathVariable Long id) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_B",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsB(application.get().getStatus())) {
                application.get().setStatus(Status.APPROVED_BY_USER_B);
                application.get().getHistories().add(new ApplicationHistory(Status.APPROVED_BY_USER_B,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-B/";
    }


    @GetMapping("/user-B/reject/{id}")
    public String inValidateByUserB(@PathVariable Long id,Principal principal) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_B",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsB(application.get().getStatus())) {
                application.get().setStatus(Status.REJECTED_BY_USER_B);
                application.get().getHistories().add(new ApplicationHistory(Status.REJECTED_BY_USER_B,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-B/";
    }



    @GetMapping("/user-C/")
    public String userC_Home(Model model) {
        List<Application> applications = this.applicationService.getAllApplication();
        model.addAttribute("applicationList",applications);
        return "UserC/home";
    }


    @GetMapping("/user-C/accept/{id}")
    public String validateByUserC(@PathVariable Long id) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_C",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsC(application.get().getStatus())) {
                application.get().setStatus(Status.APPROVED_BY_USER_C);
                application.get().getHistories().add(new ApplicationHistory(Status.APPROVED_BY_USER_C,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-C/";
    }


    @GetMapping("/user-C/reject/{id}")
    public String inValidateByUserC(@PathVariable Long id) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_C",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsC(application.get().getStatus())) {
                application.get().setStatus(Status.REJECTED_BY_USER_C);
                application.get().getHistories().add(new ApplicationHistory(Status.REJECTED_BY_USER_C,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-C/";
    }


    @GetMapping("/user-D/")
    public String userD_Home(Model model) {
        List<Application> applications = this.applicationService.getAllApplication();
        model.addAttribute("applicationList",applications);
        return "UserD/home";
    }


    @GetMapping("/user-D/accept/{id}")
    public String validateByUserD(@PathVariable Long id) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_D",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsD(application.get().getStatus())) {
                application.get().setStatus(Status.COMPLETED);
                application.get().getHistories().add(new ApplicationHistory(Status.COMPLETED,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-D/";
    }



    @GetMapping("/user-D/reject/{id}")
    public String inValidateByUserD(@PathVariable Long id) {
        Optional<Application> application = this.applicationService.getApplication(id);

        if(application.isEmpty()) {
            System.out.println("------------Application Nai------------");
        } else {
            if (accessService.hasUserAccess("ROLE_USER_D",userService.getLoggedInUser().getRole())
                    && accessService.hasPermissionsD(application.get().getStatus())) {
                application.get().setStatus(Status.REJECTED_BY_USER_D);
                application.get().getHistories().add(new ApplicationHistory(Status.REJECTED_BY_USER_D,userService.getLoggedInUser(),LocalTime.now()));
                applicationService.save(application.get());
            }
        }

        return "redirect:/user-D/";
    }
}

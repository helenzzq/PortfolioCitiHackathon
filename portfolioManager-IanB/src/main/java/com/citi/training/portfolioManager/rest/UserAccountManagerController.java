package com.citi.training.portfolioManager.rest;

import com.citi.training.portfolioManager.entities.AccountActivity;
import com.citi.training.portfolioManager.entities.User;
import com.citi.training.portfolioManager.services.PortfolioManagerService;
import com.citi.training.portfolioManager.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@CrossOrigin // allows requests from all domains
public class UserAccountManagerController {


    @Autowired
    private UserManagerService userManagerService;
    @Autowired
    private PortfolioManagerService portfolioManagerService;

    /**
     * GET Requests
     **/

    @GetMapping()
    public Collection<User> getAllUser() {
        return userManagerService.getUsers();
    }


    @GetMapping("/account")
    public Collection<AccountActivity> getAllActivity() {
        return userManagerService.getAccountActivity();
    }
    @GetMapping("/ac")
    public Optional<AccountActivity> getSingleActivity() {
        return userManagerService.getAccountActivityByDate();
    }

    //
//    @PostMapping("/update-networth/{date}")
//    public void deposit(@PathVariable("date") long date) {
//        portfolioManagerService.updateNetWorth(1, new Date(date));
//    }
    @GetMapping("/account/lastMonth")
    public Collection<AccountActivity> getLastMonthAccountActivity() {
        return portfolioManagerService.getAccountActivityByRange("lastMonth");
    }

    @GetMapping("/account/lastWeek")
    public Collection<AccountActivity> getLastWeekAccountActivity() {
        return portfolioManagerService.getAccountActivityByRange("lastWeek");
    }

    @GetMapping("/account/lastQuarter")
    public Collection<AccountActivity> getLastQuarterAccountActivity() {
        return portfolioManagerService.getAccountActivityByRange("lastQuarter");
    }

    /*
     * Path Variable date is in dd-mm-yyyy format
     * */
    @PostMapping("/delete-account-activity/{date}")
    public void deleteAccountActivity(@PathVariable("date") String date) throws ParseException {
        Date dates = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        userManagerService.deleteAccountActivity(dates);
    }

}

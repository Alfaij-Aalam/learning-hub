package com.learninghub.learninghub.controller;

import com.learninghub.learninghub.entity.Course;
import com.learninghub.learninghub.entity.User;
import com.learninghub.learninghub.repository.CourseRepository;
import com.learninghub.learninghub.repository.SubjectRepository;
import com.learninghub.learninghub.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("user", loggedInUser);
        try {
            model.addAttribute("courses", courseRepository.findAll());
        } catch (Exception e) {
            model.addAttribute("courses", null);
        }
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("loggedInUser") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam(value = "identifier", required = false) String identifier,
                              @RequestParam(value = "password", required = false) String password, 
                              HttpSession session, Model model) {
        
        if (identifier == null || identifier.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            model.addAttribute("error", "Please enter credentials!");
            return "login";
        }

        String input = identifier.trim();
        String pass = password.trim();

        if ((input.equalsIgnoreCase("Alfaiz Aalam") || input.equalsIgnoreCase("admin@learninghub.com")) 
                && pass.equals("898904")) {
            User adminUser = new User();
            adminUser.setFullName("Alfaiz Aalam (Admin)");
            adminUser.setEmail("admin@learninghub.com");
            adminUser.setRole("ADMIN");
            session.setAttribute("loggedInUser", adminUser);
            return "redirect:/";
        }

        User user = userRepository.findByEmail(input);
        if (user == null) {
            user = userRepository.findByFullName(input);
        }

        if (user != null && user.getPassword() != null && user.getPassword().equals(pass)) {
            if (user.getRole() == null || user.getRole().trim().isEmpty()) {
                user.setRole("STUDENT");
            }
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        }
        
        model.addAttribute("error", "Invalid Credentials! Check your email or password.");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam("fullName") String fullName,
                                 @RequestParam(value = "mobileNumber", required = false) String mobileNumber,
                                 @RequestParam("email") String email,
                                 @RequestParam(value = "bloodGroup", required = false) String bloodGroup,
                                 @RequestParam(value = "age", defaultValue = "20") int age,
                                 @RequestParam("password") String password,
                                 @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
                                 Model model) {
        
        if (confirmPassword != null && !password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }

        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email is already registered!");
            return "register";
        }

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setMobileNumber(mobileNumber);
        newUser.setEmail(email);
        newUser.setBloodGroup(bloodGroup);
        newUser.setAge(age);
        newUser.setPassword(password);
        newUser.setRole("STUDENT");

        userRepository.save(newUser);
        return "redirect:/login?registered=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/course/{id}")
    public String viewCourseSubjects(@PathVariable Long id, Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        Course course = courseRepository.findById(id).orElseThrow();
        model.addAttribute("user", loggedInUser);
        model.addAttribute("course", course);
        model.addAttribute("subjects", subjectRepository.findByCourseId(id));
        return "course-details";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"ADMIN".equalsIgnoreCase(loggedInUser.getRole())) {
            return "redirect:/login";
        }
        model.addAttribute("user", loggedInUser);
        model.addAttribute("students", userRepository.findAll());
        return "admin-dashboard";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteStudent(@PathVariable Long id, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"ADMIN".equalsIgnoreCase(loggedInUser.getRole())) {
            return "redirect:/login";
        }
        userRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }
}
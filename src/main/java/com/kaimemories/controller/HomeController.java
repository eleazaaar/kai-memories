
package com.kaimemories.controller;

import com.kaimemories.service.MemoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final MemoryService memoryService;

    public HomeController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("memories", memoryService.getAllMemories());
        return "index";
    }
}

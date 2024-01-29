package com.example.spring_board.controller;

import com.example.spring_board.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        // 19분부터
        return "redirect:/index";
    }
}

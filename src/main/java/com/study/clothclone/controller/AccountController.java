package com.study.clothclone.controller;

import com.study.clothclone.entity.Board;
import com.study.clothclone.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login(Model model,
                        @RequestParam @Nullable String email,
                        @RequestParam @Nullable String error){
        model.addAttribute("email", email == null ? "" : email);
        model.addAttribute("error", error == null ? "" : error);
        return "account/login";
    }

    @GetMapping("/account/register")
    public String register(){
        return "account/register";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/join")
    public String join(){
        return "join/join";
    }

    @GetMapping("/")
    public String mainpage(){
        return "page/main";
    }

    @GetMapping("/rproduct")
    public String rproduct(){
        return "productpage/rproduct";
    }


    @GetMapping("/Q&A")
    public String qna(){
        return "page/qna";
    }

    @GetMapping("/notice")
    public String notice(){
        return "page/notice";
    }

    @GetMapping("/cart")
    public String cart(){
        return "cart/cart";
    }

    @GetMapping("/board")
    public String board(){
        return "page/board";
    }

    @Autowired
    private BoardService boardService;
    @PostMapping("/boardlist")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "page/boardlist";
    }
    @GetMapping("/boardlist")
    public String boardList(Model model){

        model.addAttribute("list",boardService.boardList());

        return "page/boardlist";
    }
    @GetMapping("/boardview")
    public String boardView(Model model,Integer id){

        model.addAttribute("board",boardService.boardView(id));
        return "page/boardview";
    }
}

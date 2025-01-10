package site.unoeyhi.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import site.unoeyhi.guestbook.domain.dto.PageRequestDto;
import site.unoeyhi.guestbook.service.GuestbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;


@Controller
@Log4j2
@RequestMapping("guestbook")
public class GuestBookController {
    @Inject
    private GuestbookService service;

    @GetMapping({"","/","list"})
    public String list(Model model, PageRequestDto dto) {
        log.info("list");
        model.addAttribute("result", service.list(dto));
       return "/guestbook/list"; 
    } 
    
}
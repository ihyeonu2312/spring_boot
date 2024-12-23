package site.unoeyhi.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexComtroller {
  @GetMapping("/")
  public String index() {
      return "index";
  }
  
}

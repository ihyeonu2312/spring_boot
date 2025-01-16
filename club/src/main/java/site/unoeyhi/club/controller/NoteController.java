package site.unoeyhi.club.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import site.unoeyhi.club.entity.dto.NoteDto;
import site.unoeyhi.club.service.NoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/notes/")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private NoteService service;
    
    @PostMapping
    public Long post(@RequestBody NoteDto noteDto) {
        return service.register(noteDto);
    }
  
    @GetMapping("list")
    public List<NoteDto> list(String email) {
        return service.listByEmail(email);
    }
  
    @GetMapping("listall")
    public List<NoteDto> listAll() {
        return service.listAll();
    }
  
    @SuppressWarnings("unchecked")
    @GetMapping("{num}")
    public ResponseEntity<?> get(@PathVariable Long num) {
      log.info(num);
      log.info(service.get(num));
      return service.get(num).map(note -> ResponseEntity.ok(note))
        .orElseGet(() -> {
          Map<String, Object> ret = new HashMap<>();
          ret.put("code", 404);
          ret.put("message", "NOT_FOUND");
          ResponseEntity<?> entity = new ResponseEntity<>(ret, HttpStatus.NOT_FOUND);
          return (ResponseEntity<NoteDto>) entity;
      }); 

    @PutMapping("{num}")
    public String modify(@PathVariable Long num, @RequestBody NoteDto noteDto) {
      try {
          service.modify(noteDto);
          return "success";
      } catch (Exception e) {
          return "failure";
      }
    }

    @DeleteMapping("{num}")
    public String remove(@PathVariable Long num) {
      try {
          service.remove(num);
          return "success";
      } catch (Exception e) {
          return "failure";
      }
    }
    

    
    
  }
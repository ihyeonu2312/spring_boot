package site.unoeyhi.todo.dto;

import javax.swing.text.html.parser.Entity;

import site.unoeyhi.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoWirteDto {
  private String task;
 

  public TodoWirteDto(TodoEntity entity){
    task = entity.getTask();
 
  }

 
  //dto >> entity
  public TodoEntity todoEntity(){
    return TodoEntity.builder().task(task).build();
  }
}

package site.unoeyhi.todo.dto;

import javax.swing.text.html.parser.Entity;

import site.unoeyhi.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoListDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoListDto(TodoEntity entity){
    id = entity.getId();
    task = entity.getTask();
    done = entity.isDone();
  }

 
  //dto >> entity
  public TodoEntity todoEntity(){
    return TodoEntity.builder().id(id).task(task).done(done).build();
  }
}

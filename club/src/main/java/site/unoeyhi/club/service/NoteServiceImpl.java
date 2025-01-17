package site.unoeyhi.club.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import site.unoeyhi.club.entity.Note;
import site.unoeyhi.club.entity.dto.NoteDto;
import site.unoeyhi.club.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
  
  private final NoteRepository noteRepository;

  @Override
    public Long register(NoteDto noteDTO) {
        Note note = dtoToEntity(noteDTO);

        log.info("===========================");
        log.info(note);
        
        noteRepository.save(note);
        
        return note.getNum();
    }

    @Override
    public NoteDto get(Long num) {
      Note note = noteRepository.findByNum(num);
      // if (result.isPresent()) {
      //     return entityToDTO(result.get());
      // }
        
      return null;
    }

    @Override
    public void modify(NoteDto noteDTO) {
        Long num = noteDTO.getNum();
        Optional<Note> result = noteRepository.findById(num);

        if (result.isPresent()) {
            Note note = result.get();
            
            note.changeTitle(noteDTO.getTitle());
            note.changeContent(noteDTO.getContent());

            noteRepository.save(note);
        }
    }

    @Override
    public Optional<NoteDto> get(Long num) {
        long count = likesRepository.count(Example.of(Likes.builder().note(Note.builder().num(num).build()).build()));
        log.info(count);
        return repository.findById(num).map(this::toDto).map(d -> { d.setLikesCnt(count); return d; });
    }

    @Override
    public List<NoteDto> list(String email) {
        repository.findNotesBy(email).stream().map(o -> {
            NoteDto dto = toDto((Note)o[0]);
            dto.setLikesCnt((Long)o[1]);
            dto.setAttachCnt((Long)o[2]);
            return dto;
        }).toList();

    }

    @Override
    public void remove(Long num) {
        repository.deleteById(num);
        return 1;
    }

    @Override
    public List<NoteDto> getAllWithwriter(String writerEmail) {
        List<Note> noteList = noteRepository.getAllWithWriter(writerEmail);

        return noteList.stream().map(note -> entityToDTO(note)).collect(Collectors.toList());
    }
}
  


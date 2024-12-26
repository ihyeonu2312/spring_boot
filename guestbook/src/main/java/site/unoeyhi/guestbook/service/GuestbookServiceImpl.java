package site.unoeyhi.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import site.unoeyhi.guestbook.domain.dto.GuestbookDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookModifyDto;
import site.unoeyhi.guestbook.domain.dto.GuestbookViewDto;
import site.unoeyhi.guestbook.domain.dto.PageRequestDto;
import site.unoeyhi.guestbook.domain.dto.PageResultDto;
import site.unoeyhi.guestbook.domain.entity.Guestbook;
import site.unoeyhi.guestbook.repository.GuestbookRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class GuestbookServiceImpl implements GuestbookService {
    private GuestbookRepository repository; //레포지토리 가져오기
    

    // public List<GuestbookListDto> list(){
    //     return repository.findAll().stream().map(GuestbookListDto :: new).toList();
    // };
    @Override
    public GuestbookViewDto get(Long gno){
        Optional<Guestbook> opt = repository.findById(gno);
        if(!opt.isPresent()){
            return null;
        }
        return new GuestbookViewDto(opt.get());

    @Override
    public void modify(GuestbookModifyDto dto){
        repository.save(dto.toEntity());
    }
    @Override
    public void remove(Long gno){
        repository.deleteById(gno);
    }
    @Override
    public Long writer(GuestbookDto dto){
        Guestbook guestbook = toEntity(dto);
        log.info(guestbook);
        repository.save(guestbook);
        log.info(guestbook);
        return guestbook.getGno();
    }
    @Override
    public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
        Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "gno"));
        Page<Guestbook> page = repository.findAll(pageable);
        // Function<Guestbook, GuestbookDto> fn = e -> toDto(e);
        PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, e -> toDto(e));


        return null;
    }

}

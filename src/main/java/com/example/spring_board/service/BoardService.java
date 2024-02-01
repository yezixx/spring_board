package com.example.spring_board.service;

import com.example.spring_board.dto.BoardDTO;
import com.example.spring_board.entity.BoardEntity;
import com.example.spring_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// repository에서는 Entity로만 데이터를 주고받음
// DTO -> Entity (컨트롤러에서 받아올 때, Entity Class에서)
// Entity -> DTO (컨트롤러로 넘겨줄 때, DTO Class에서)

@Service
@RequiredArgsConstructor
public class BoardService {
    private  final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll(){
        List<BoardEntity> boardEntityList=boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(BoardEntity boardEntity: boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}

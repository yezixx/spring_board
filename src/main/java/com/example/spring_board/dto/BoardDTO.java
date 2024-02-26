package com.example.spring_board.dto;

import com.example.spring_board.entity.BoardEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

// DTO(Data Transfer Object), VO, Bean (비슷함)     Entity (조금 다름)
// 데이터를 하나의 객체에 담아서 보내는 것
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits; // 게시글 조회수
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;
    
    private MultipartFile boardFile; // save.html에서 Controller로 넘어올 때 파일을 담는 용도
    private String originalFileName; // 원본 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름 (중복된 파일 이름 방지)
    private int fileAttached; // 파일 첨부 여부(첨부 1, 미첨부 0)

    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());

        if(boardEntity.getFileAttached() == 0){
            boardDTO.setFileAttached(boardEntity.getFileAttached());
        }else{
            boardDTO.setFileAttached(boardEntity.getFileAttached());
            // 파일 이름을 가져가야 함. datail.html의 storedFileName에
            // originalFileName, storedFileName -> board_file_table(boardFileEntity)에 있음
            // join 문법
            // select * from board_table b, board_file_table bf where b.id=bf.board_id and where b.id=?
            boardDTO.setOriginalFileName(boardEntity.getBoardFileEntityList().get(0).getOriginalFileName());
            // 엔티티에 있는 보드파일엔티티리스트(자식데이터들)에 접근하여 첫번째 인덱스에 있는 값의 오리지널파일네임
            boardDTO.setStoredFileName(boardEntity.getBoardFileEntityList().get(0).getStoredFileName());
        }
        return boardDTO;
    }
}

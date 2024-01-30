package com.example.spring_board.entity;

import com.example.spring_board.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entity: DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name="board_table") //테이블 이름 따로 정해주고 싶을 때 사용
public class BoardEntity extends BaseEntity{
    @Id // pk 컬럼 지정, 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment(mySQL 기준)
    private Long id;

    @Column(length=20, nullable = false) // 크기 20, null 불가능
    private String boardWriter;

    @Column // 디폴트 값(크기 255, null 가능)
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardEntity.getBoardContents());
        boardEntity.setBoardHits(0);

        return boardEntity;
    }
}

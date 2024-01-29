package com.example.spring_board.dto;

import lombok.*;

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
    private LocalDateTime boardCreateTime;
    private LocalDateTime boardUpdateTime;
}

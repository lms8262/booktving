package com.ezen.booktving.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.QuestionStatus;
import com.ezen.booktving.entity.Member;
import com.ezen.booktving.entity.Question;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QuestionDto {
   private Long id;
   
   @NotBlank
   private String title;
   
   @NotBlank
   private String content;
   
   private Member member;
   
   private MemberDto memberDto;
   
   private LocalDate questionDate;
   
   private QuestionStatus questionStatus;
   
   private static ModelMapper modelMapper = new ModelMapper();
      
   public Question createQuestion() {
      Question question = modelMapper.map(this, Question.class);
      question.setMember(memberDto.createMember());
      return question;
   }
   
   public static QuestionDto of(Question question) {
      QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
      questionDto.setMemberDto(MemberDto.of(question.getMember()));

      return questionDto;
   }
}
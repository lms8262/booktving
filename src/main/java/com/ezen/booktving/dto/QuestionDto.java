package com.ezen.booktving.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ezen.booktving.constant.QuestionStatus;
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
   
   private LocalDate questionDate;
   
   private QuestionStatus questionStatus;
      
   public static QuestionDto of(Question question, ModelMapper modelMapper) {
      QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
      return questionDto;
   }
}
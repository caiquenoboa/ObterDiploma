package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SubjectDTO {
  @NotNull(message = "O nome é obrigatório")
  @Size(min=8,max = 50, message = "O nome da matéria deve ser maior que 8 e menor que 50.")
  @Pattern(regexp = "[\\p{L}\\s]*", message = "O nome da matéria só pode conter letras")
  private String subject;

  @Range(min = 0, max = 10, message = "O número da nota deve ser um inteiro entre 0 e 10")
  @NotNull(message = "Deve colocar nota")
  private Integer note;

  public SubjectDTO(String subject, Integer note) {
    this.subject = subject;
    this.note = note;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}

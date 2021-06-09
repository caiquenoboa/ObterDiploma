package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SubjectDTO {
  @Size(min=8,max=50, message = "O nome da matéria deve ser maior que 8 e menor que 50.")
  @Pattern(regexp = "[A-Za-z ]*", message = "O nome da matéria só pode conter letras")
  private String subject;

  @Range(min = 0, max = 10, message = "O número da nota deve ser um inteiro entre 0 e 10")
  private Integer note;

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

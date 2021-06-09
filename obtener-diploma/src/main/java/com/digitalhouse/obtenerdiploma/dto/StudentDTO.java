package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class StudentDTO {
    @NotNull(message = "O nome é obrigatório")
    @Size(min=8,max = 50, message = "O nome do estudante deve ser maior que 8 e menor que 50.")
    @Pattern(regexp = "[\\p{L}\\s]*", message = "O nome do estudante só pode conter letras")
    private String name;


    @Valid
    @NotEmpty(message = "Deve conter matérias")
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}

package com.digitalhouse.obtenerdiploma.units;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObtenerDiplomaApplicationTests {

  private CertificateServiceImpl certificateService = new CertificateServiceImpl();

  @Test
  void analizeNotesMelhorNotas() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("Calculo", 10));
    subjectDTOList.add(new SubjectDTO("Fisica", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 10));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    CertificateDTO certificateDTO = certificateService.analyzeNotes(studentDTO);

    assertEquals(certificateDTO.getAverage(), 10);

  }

  @Test
  void analizeNotesNotMelhorNotas() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("CalculoOne", 10));
    subjectDTOList.add(new SubjectDTO("FisicaOne", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 10));

    StudentDTO studentDTO = new StudentDTO("Caique Noboa", subjectDTOList);

    certificateService.validate(studentDTO);

    CertificateDTO certificateDTO = certificateService.analyzeNotes(studentDTO);

    assertNotEquals(certificateDTO.getAverage(), 9);

  }


  @Test
  void analizeNotesPiorNotas() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 5));
    subjectDTOList.add(new SubjectDTO("Calculo", 4));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 2));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 1));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    CertificateDTO certificateDTO = certificateService.analyzeNotes(studentDTO);

    assertEquals(certificateDTO.getAverage(), 3);

  }

  @Test
  void calculeAvarageMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("Calculo", 10));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 10));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    Double avarage = certificateService.calculateAverage(studentDTO);

    assertEquals(avarage, 10);
  }

  @Test
  void calculeAvarageNotMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("Calculo", 10));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 10));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    Double avarage = certificateService.calculateAverage(studentDTO);

    assertNotEquals(avarage, 9);
  }

  @Test
  void calculeAvaragePiorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 5));
    subjectDTOList.add(new SubjectDTO("Calculo", 4));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 2));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 1));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    Double avarage = certificateService.calculateAverage(studentDTO);

    assertEquals(avarage, 3);
  }

  @Test
  void writeDiplomasMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 7));
    subjectDTOList.add(new SubjectDTO("Calculo", 7));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 9));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 9));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    String string = certificateService.writeDiploma(studentDTO);

    assertEquals(string, "Caique usted ha conseguido el promedio de 8.0");
  }

  @Test
  void writeDiplomasNotMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 7));
    subjectDTOList.add(new SubjectDTO("Calculo", 7));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 9));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 9));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    String string = certificateService.writeDiploma(studentDTO);

    assertNotEquals(string, "Caique usted ha conseguido el promedio de 7.0");
  }

  @Test
  void writeDiplomasPiorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 5));
    subjectDTOList.add(new SubjectDTO("Calculo", 4));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 2));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 1));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    String string = certificateService.writeDiploma(studentDTO);

    assertEquals(string, "Caique usted ha conseguido el promedio de 3.0");
  }


  @Test
  void withHonorsMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("Calculo", 10));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 10));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    String string = certificateService.writeDiploma(studentDTO);

    assertEquals(string, "¡Felicitaciones Caique! Usted tiene el gran promedio de 10.0");
  }

  @Test
  void withHonorsNotMelhorMedia() throws Exception{
    List<SubjectDTO> subjectDTOList = new ArrayList<>();
    subjectDTOList.add(new SubjectDTO("Programação", 10));
    subjectDTOList.add(new SubjectDTO("Calculo", 10));
    subjectDTOList.add(new SubjectDTO("Fisica 1", 10));
    subjectDTOList.add(new SubjectDTO("Geometria Analitica", 9));

    StudentDTO studentDTO = new StudentDTO("Caique", subjectDTOList);

    String string = certificateService.writeDiploma(studentDTO);

    assertNotEquals(string, "¡Felicitaciones Caique! Usted tiene el gran promedio de 10.0");
  }



}

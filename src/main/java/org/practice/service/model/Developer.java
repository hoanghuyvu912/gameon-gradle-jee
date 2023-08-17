package org.practice.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

import static org.practice.exception.ErrorMessage.DEVELOPER_NAME_LENGTH_CONSTRAINT;
import static org.practice.exception.ErrorMessage.DEVELOPER_NAME_NULL_OR_BLANK;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    private Integer id;

    @NotBlank(message = DEVELOPER_NAME_NULL_OR_BLANK)
    @Size(max = 500, message = DEVELOPER_NAME_LENGTH_CONSTRAINT)
    private String name;

    private String thumbnail;

    private String coverPhoto;

    private String description;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate establishedDate;

    private List<Game> gameList;
}


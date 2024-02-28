package org.surfsharing.groupeservice.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupeUserDto implements Serializable {
    Long id;
    Long userId;
    Long groupeId;
    boolean deleted;

    public GroupeUserDto(String s) {
    }
}
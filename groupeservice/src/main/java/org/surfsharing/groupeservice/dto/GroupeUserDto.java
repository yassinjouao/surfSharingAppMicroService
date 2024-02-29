package org.surfsharing.groupeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupeUserDto implements Serializable {
    Long id;
    Long userId;
    Long groupeId;
    boolean deleted;

//    public GroupeUserDto(String s) {
//    }
}
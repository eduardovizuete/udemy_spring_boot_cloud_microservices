package net.javaguides.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private Long id;

    private String organizationName;

    private String organizationDesc;

    private String organizationCode;

    private String createdDate;

}

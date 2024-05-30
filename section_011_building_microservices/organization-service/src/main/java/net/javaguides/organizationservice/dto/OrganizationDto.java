package net.javaguides.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "OrganizationDto model information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private Long id;

    @Schema(description = "Organization name")
    private String organizationName;

    @Schema(description = "Organization description")
    private String organizationDescription;

    @Schema(description = "Organization code")
    private String organizationCode;

    @Schema(description = "Organization created date")
    private String createdDate;

}

package co.bpop.hipotecario.qa.ui.abilities.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StatusTest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("status_ind")
    private String statusInd;
}

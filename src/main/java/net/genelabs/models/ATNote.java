package net.genelabs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ATNote {
    int AT_ticket_id;
    String description;
    int noteType;
    int publish;
    String created;
    String title = "THIS COMMENT IMPORTED FROM THE OVS SYSTEM";

}

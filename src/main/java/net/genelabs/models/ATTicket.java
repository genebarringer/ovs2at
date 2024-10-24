package net.genelabs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ATTicket {
    String legacyTicketId;
    String description;
    String contact;
    String priority;
    String created;
}

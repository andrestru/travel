package com.ias.testTecnico.domain.model.tickets.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    private Document cc;
    private Name name;
    private Travel id_travel;

}

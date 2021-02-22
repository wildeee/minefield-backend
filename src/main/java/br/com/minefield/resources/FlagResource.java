package br.com.minefield.resources;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.minefield.dto.FlagDTO;
import br.com.minefield.services.FlagService;

@Path("/flag")
public class FlagResource {

    private final FlagService flagService;

    public FlagResource(FlagService flagService) {
        this.flagService = flagService;
    }

    @POST
    @Transactional
    public Long flag(@Valid FlagDTO flag) {
        return flagService.flag(flag);
    }
}

package br.com.minefield.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.minefield.dto.CoordinateDTO;
import br.com.minefield.dto.GameStatusAndBombsAroundDTO;
import br.com.minefield.dto.PointDTO;
import br.com.minefield.services.MapService;
import br.com.minefield.services.RevealService;

@Path("/map")
public class MapResource {

    private final MapService mapService;
    private final RevealService revealService;

    public MapResource(MapService mapService, RevealService revealService) {
        this.mapService = mapService;
        this.revealService = revealService;
    }

    @GET
    public List<CoordinateDTO> getMap() {
        return mapService.getMap();
    }

    @POST
    @Transactional
    @Path("/reveal")
    public GameStatusAndBombsAroundDTO reveal(@Valid PointDTO point) {
        return revealService.reveal(point);
    }

}

package br.com.minefield.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.minefield.dto.CoordinateDTO;
import br.com.minefield.services.MapService;

@Path("/map")
public class MapResource {

    private final MapService mapService;

    public MapResource(MapService mapService) {
        this.mapService = mapService;
    }

    @GET
    public List<CoordinateDTO> getMap() {
        return mapService.getMap();
    }

}

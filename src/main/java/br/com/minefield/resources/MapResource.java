package br.com.minefield.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.minefield.domain.Coordinate;

@Path("/map")
public class MapResource {

    @GET
    public List<Coordinate> getMap() {
        return Coordinate.listAll();
    }

}

package br.com.minefield.services;

import javax.enterprise.context.ApplicationScoped;

import br.com.minefield.domain.Coordinate;
import br.com.minefield.dto.FlagDTO;

@ApplicationScoped
public class FlagService {

    public Long flag(FlagDTO flag) {
        Coordinate coordinate = Coordinate.find("x = ?1 and y = ?2", flag.x, flag.y).firstResult();
        coordinate.setFlagged(flag.flagged);
        coordinate.persistAndFlush();
        Long bombAmount = Coordinate.count("bomb is true");
        Long flagAmount = Coordinate.count("flagged is true");
        return bombAmount - flagAmount;
    }

}

package org.apatrios.controller.dictionary.point;

import lombok.RequiredArgsConstructor;
import org.apatrios.controller.dictionary.SimpleDictionaryController;
import org.apatrios.model.dictoinary.Point;
import org.apatrios.service.dictionary.PointService;
import org.apatrios.service.dictionary.SimpleDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController extends SimpleDictionaryController<Point> {

    private final PointService service;

    @Override
    protected SimpleDictionaryService<Point> getService() {
        return this.service;
    }
}

package com.vinizorza.urnaeletronica.controller;

import com.vinizorza.urnaeletronica.controller.dto.CandidateDTO;
import com.vinizorza.urnaeletronica.controller.dto.CandidateResultDTO;
import com.vinizorza.urnaeletronica.controller.mapper.CandidateMapper;
import com.vinizorza.urnaeletronica.entity.Position;
import com.vinizorza.urnaeletronica.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    private CandidateService service;
    private CandidateMapper mapper;

    public CandidateController(final CandidateService service, final CandidateMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{number}")
    public ResponseEntity<CandidateDTO> getCandidateByNumber(@PathVariable String number) throws Exception {
        return ResponseEntity.ok(mapper.toDto(service.findByNumber(number)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/result")
    public ResponseEntity<List<CandidateResultDTO>> getResult(@RequestParam(required = false) Position position,
                                                              @RequestParam(required = false) String state,
                                                              @RequestParam(required = false) String city) throws Exception {

        return ResponseEntity.ok(service.listByPositionOrStateOrCity(position, state, city));
    }
}

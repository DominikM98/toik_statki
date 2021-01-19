package com.example.kolokwium_2.service;

import com.example.kolokwium_2.dto.PlanszaDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatkiServiceImpl implements StatkiService{

    private final int SIZE = 8;

    private PlanszaDto planszaDto;

    public StatkiServiceImpl() {
        String[] plns = {"","S","","","","S","","S"};
        planszaDto = new PlanszaDto(plns);
    }

    @Override
    public PlanszaDto getPlansza() {
        return planszaDto;
    }

    @Override
    public Optional<Boolean> shot(int position) {
        if(position >= SIZE || position < 0 || planszaDto.getPlansza()[position].equals("X") || planszaDto.getPlansza()[position].equals("O")){
            return Optional.empty();
        }
        if(planszaDto.getPlansza()[position].equals("S")){
            planszaDto.getPlansza()[position] = "X";
            return Optional.of(true);
        }
        planszaDto.getPlansza()[position] = "O";
        return Optional.of(false);
    }
}

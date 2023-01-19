package com.example.SpringBatchHelloWorld.steps;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Tarea2 implements Tasklet{

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Tarea 1 ejecutando");
        log.debug("Tarea 1 ejecutando");
        return RepeatStatus.FINISHED;
    }
    
}

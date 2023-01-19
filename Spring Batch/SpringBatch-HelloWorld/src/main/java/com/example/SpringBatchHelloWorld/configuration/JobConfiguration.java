package com.example.SpringBatchHelloWorld.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBatchHelloWorld.steps.Tarea1;
import com.example.SpringBatchHelloWorld.steps.Tarea2;
import com.example.SpringBatchHelloWorld.steps.Tarea3;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("paso1")
        .tasklet(new Tarea1())
        .build();
    }
    
    @Bean
    public Step step2(){
        return stepBuilderFactory.get("paso1")
        .tasklet(new Tarea2())
        .build();
    }

    @Bean
    public Step step3(){
        return stepBuilderFactory.get("paso1")
        .tasklet(new Tarea3())
        .build();
    }

    @Bean Job holaMundoJob(){

        return jobBuilderFactory.get("holamundoJob")
        .start(step1())
        .next(step2())
        .next(step3())
        .build();
    }
}

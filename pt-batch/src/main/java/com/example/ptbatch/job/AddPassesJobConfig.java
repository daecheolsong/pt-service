package com.example.ptbatch.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daecheol song
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class AddPassesJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final AddPassesTasklet addPassesTasklet;

    @Bean
    public Job addPassesJob() {
        return this.jobBuilderFactory.get("addPassesJob")
                .start(addPassesStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }


    @Bean
    public Step addPassesStep() {
        return this.stepBuilderFactory.get("addPassesStep")
                .tasklet(addPassesTasklet)
                .build();
    }

}

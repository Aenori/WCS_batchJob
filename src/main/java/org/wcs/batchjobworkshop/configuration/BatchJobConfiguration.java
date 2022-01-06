package org.wcs.batchjobworkshop.configuration;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wcs.batchjobworkshop.entity.HeartBeat;
import org.wcs.batchjobworkshop.repository.HeartBeatRepository;

import java.time.LocalDate;

@Configuration
@EnableBatchProcessing
public class BatchJobConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private HeartBeatRepository heartBeatRepository;

    @Bean
    public Step heartBeat() {
        return this.stepBuilderFactory
                .get("heartBeatStep")
                .tasklet(
                        (StepContribution stepContribution, ChunkContext chunkContext) -> {
                            heartBeatRepository.save(
                                    new HeartBeat(
                                            LocalDate.now(),
                                            "HeartBeatStep"
                                    )
                            );

                            return RepeatStatus.FINISHED;
                        }
                )
                .build();
    }
}

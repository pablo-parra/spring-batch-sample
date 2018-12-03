package pab.par.dom.springbatchsample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Basic Job
 *
 */
@Configuration
@EnableBatchProcessing
public class JobConfiguration {

  private static final Logger log = LoggerFactory.getLogger(JobConfiguration.class);

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job myJob() {

    log.info("Starting myJob...");
    return this.jobBuilderFactory.get("myJob").start(step1()).build();
  }

  @Bean
  public Step step1() {

    log.info("In Step1...");
    return this.stepBuilderFactory.get("step1").tasklet((contribution, chunkContext) -> null).build();
  }
}

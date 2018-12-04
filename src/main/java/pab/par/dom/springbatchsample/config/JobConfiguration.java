package pab.par.dom.springbatchsample.config;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pab.par.dom.springbatchsample.service.data.entity.Student;
import pab.par.dom.springbatchsample.service.logic.api.Studentmanagement;

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

  @Autowired
  private Studentmanagement studentManagement;

  @Bean
  public Job myJob() {

    log.info("Starting myJob...");
    return this.jobBuilderFactory.get("myJob").start(step1()).next(chunkStep()).build();
  }

  @Bean
  public Step step1() {

    log.info("In Step1...");
    return this.stepBuilderFactory.get("step1").tasklet((contribution, chunkContext) -> null).build();
  }

  @Bean
  public Step chunkStep() {

    return this.stepBuilderFactory.get("chunkStep").<Student, Student> chunk(3).reader(reader()).processor(processor())
        .writer(writer()).build();
  }

  @Bean
  @StepScope
  public ItemReader<Student> reader() {

    return new StudentItemReader();
  }

  @Bean
  @StepScope
  public ItemProcessor<Student, Student> processor() {

    final CompositeItemProcessor<Student, Student> processor = new CompositeItemProcessor<>();
    processor.setDelegates((List<? extends ItemProcessor<?, ?>>) Arrays.asList(new EnabledFilterProcessor()));
    return processor;
  }

  @Bean
  @StepScope
  public ItemWriter<Student> writer() {

    return new StudentItemWriter();
  }
}

package pab.par.dom.springbatchsample.jobmanagement.jobconfig;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;

/**
 * Basic Job
 *
 */
@Configuration
@EnableBatchProcessing
@EnableAsync
public class JobConfiguration {

  private static final Logger log = LoggerFactory.getLogger(JobConfiguration.class);

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean(name = "enabledStudentsJob")
  public Job enabledStudentsJob() {

    log.info("Configuring enabledStudentsJob...");
    return this.jobBuilderFactory.get("enabledStudentsJob").start(cleanDb())
        .next(processStudent(reader(), processor(), writer())).build();
  }

  @Bean(name = "enabledStudentsJobAsync")
  public Job enabledStudentsJobAsync() {

    log.info("Configuring enabledStudentsJobAsync...");
    return this.jobBuilderFactory.get("enabledStudentsJobAsync").start(cleanDb())
        .next(processStudent(reader(), processor(), writer())).build();
  }

  @Bean
  public Step step1() {

    log.info("Configuring Step1...");
    return this.stepBuilderFactory.get("step1").tasklet((contribution, chunkContext) -> null).build();
  }

  @Bean
  public Step cleanDb() {

    log.info("Configuring cleanDb step...");
    return this.stepBuilderFactory.get("cleanDb").tasklet(dbCleaner()).build();
  }

  @Bean
  public Step chunkStep() {

    log.info("Configuring chunkStep...");
    return this.stepBuilderFactory.get("chunkStep").<Student, Student> chunk(3).reader(reader()).processor(processor())
        .writer(writer()).build();
  }

  @Bean
  protected Step processStudent(ItemReader<Student> reader, ItemProcessor<Student, Student> processor,
      ItemWriter<Student> writer) {

    log.info("Configuring processStudent step...");
    return this.stepBuilderFactory.get("processStudent").<Student, Student> chunk(3).reader(reader).processor(processor)
        .writer(writer).build();
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
    processor.setDelegates(Arrays.asList(new EnabledFilterProcessor()));
    return processor;
  }

  @Bean
  @StepScope
  public ItemWriter<Student> writer() {

    return new StudentItemWriter();
  }

  @Bean
  @StepScope
  public Tasklet dbCleaner() {

    return new EnabledStudentCleaner();
  }
}

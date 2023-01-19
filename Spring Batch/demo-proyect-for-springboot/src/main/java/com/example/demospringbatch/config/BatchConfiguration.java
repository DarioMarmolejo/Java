package com.example.demospringbatch.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import org.springframework.jdbc.core.RowMapper;

import com.example.demospringbatch.model.entity.PolicyEntity;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcCursorItemReader<PolicyEntity> reader() {
        JdbcCursorItemReader<PolicyEntity> reader = new JdbcCursorItemReader<PolicyEntity>();
        reader.setDataSource(dataSource);
        reader.setSql("select id, status_policy, token from \"policy\" p where status_policy = 8");
        reader.setRowMapper(new RowMapper<PolicyEntity>() {

            @Override
            public PolicyEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                PolicyEntity s = new PolicyEntity();
                s.setId(rs.getInt("id"));
                s.setStatusPolicy(rs.getInt("status_policy"));
                s.setToken(rs.getString("token"));
                return s;
            }
        });
        return reader;
    }

    @Bean
    public FlatFileItemWriter<PolicyEntity> writer() {
        FlatFileItemWriter<PolicyEntity> writer = new FlatFileItemWriter<PolicyEntity>();
        writer.setResource(new FileSystemResource("/home/habil-pc/Documentos/policy.csv"));
        DelimitedLineAggregator<PolicyEntity> aggregator = new DelimitedLineAggregator<>();
        BeanWrapperFieldExtractor<PolicyEntity> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[] {"id","statusPolicy","token"});
        aggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(aggregator);
        return writer;
    }

    @Bean
    public Step executeStep(){
        return stepBuilderFactory.get("executeStep")
        .<PolicyEntity,PolicyEntity>chunk(10)
        .reader(reader())
        .writer(writer())
        .build();
    }

    @Bean
    public Job proccesJob(){
        return jobBuilderFactory.get("processJob")
        .incrementer(new RunIdIncrementer())
        .flow(executeStep())
        .end()
        .build();
    }


}

package com.lokal;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.elasticsearch.config.EsConfiguration;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;


public class LokalDemoConfiguration extends Configuration {
    @NotEmpty
    private String elasticsearchHost = "localhost:9200";

    @NotEmpty
    private String clusterName = "elasticsearch";

    @JsonProperty
    public String getElasticsearchHost() {
        return elasticsearchHost;
    }

    @JsonProperty
    public void setElasticsearchHost(String elasticsearchHost) {
        this.elasticsearchHost = elasticsearchHost;
    }

    @JsonProperty
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }


    @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }

    private EsConfiguration esConfiguration = new EsConfiguration();

    public EsConfiguration getEsConfiguration() {
        return esConfiguration;
    }

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
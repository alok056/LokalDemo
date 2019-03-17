package com.lokal;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.validator.internal.util.logging.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LokalDemoApplication extends Application<LokalDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LokalDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "LokalDemo";
    }

    @Override
    public void initialize(final Bootstrap<LokalDemoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LokalDemoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat())
        environment.getObjectMapper().setDateFormat(eventDateFormat);
    }

}

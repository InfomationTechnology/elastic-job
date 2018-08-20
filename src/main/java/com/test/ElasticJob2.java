package com.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "elasticJob2")
public class ElasticJob2 implements SimpleJob {
    Logger logger = LogManager.getLogger(ElasticJob2.class);

    @Override
    public void execute(ShardingContext context) {
                logger.info("333", this.getClass(), "================>:"
                        + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}

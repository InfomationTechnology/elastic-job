package com.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "myElasticJob")
public class MyElasticJob implements SimpleJob {
    Logger logger = LogManager.getLogger(MyElasticJob.class);

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                logger.info("000", this.getClass(), "================>:"
                        + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                break;
            case 1:
                logger.info("111", this.getClass(), "================>:"
                        + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                break;
            case 2:
                logger.info("222", this.getClass(), "================>:"
                        + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                break;
            // case n: ...
        }
    }
}

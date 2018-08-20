/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 此类特点：<br>
 * 1.需要继承SimpleJobBasic类；<br>
 * 2.只需要完成process方法，实现具体业务逻辑；<br>
 * 3.若需要自己的日志带上本任务的特定描述，可以在init（）方法中进行赋值；<br>
 * 4.本类，需要加入spring的扫描中，加上@Component注解；<br>
 * 5.在xml相应的位置，加上如：<job:simple id="demoJob" job-ref="demoJob" cron="*\/5 * * * * ?"/>；
 * 6.若本方法，需要特定的分片或者特定的描述等参数，具体参考DOC
 */
@Component(value = "demoJob")
public class DemoJob implements SimpleJob {


    /**
     * 定时任务业务逻辑处理
     *
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        //此处，若不需要分片，直接写需要处理的业务逻辑
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("进入分片一，业务：睡眠10秒"+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                try {
                    Thread.sleep(10 * 1000);       //业务逻辑处理地方
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                System.out.println("进入分片二，业务：睡眠6秒");
                try {
                    Thread.sleep(6 * 1000);       //业务逻辑处理地方
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}

/*
 * Copyright (C) 2020 The zfoo Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.tank.single;
import com.zfoo.event.model.event.AppStartEvent;
import com.zfoo.net.core.tcp.TcpServer;
import com.zfoo.util.net.HostAndPort;
import com.zfoo.util.net.NetUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jaysunxiao
 * @version 1.0
 * @since 2021-01-20 16:00
 */
public class Application {

    public static final int DEFAULT_PORT = 18000;

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        context.registerShutdownHook();
        context.publishEvent(new AppStartEvent(context));

        var tcpServer = new TcpServer(HostAndPort.valueOf(NetUtils.getLocalhostStr(), DEFAULT_PORT));
        tcpServer.start();
    }

}
